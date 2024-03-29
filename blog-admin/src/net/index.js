import axios from "axios";
import {ElMessage} from "element-plus";
import {useUserStore} from "@/stores/user.js";
import config from "@/config/index.js"


const authItemName = "authorize"
const api = axios.create({
    baseURL: config.api
});

const accessHeader = () => {
    return {
        'Authorization': `Bearer ${takeAccessToken()}`
    }
}
const defaultError = (error) => {
    console.error(error)
    ElMessage.error('发生了一些错误，请联系管理员')
}

const defaultFailure = (message, status, url) => {
    console.warn(`请求地址: ${url}, 状态码: ${status}, 错误信息: ${message}`)
    ElMessage.warning(message)
}
function storeAccessToken(remember, token, expire){
    const authObj = {
        token: token,
        expire: expire
    }
    const str = JSON.stringify(authObj)
    if(remember)
        localStorage.setItem(authItemName, str)
    else
        sessionStorage.setItem(authItemName, str)
}
function deleteAccessToken() {
    localStorage.removeItem(authItemName)
    sessionStorage.removeItem(authItemName)
}
function takeAccessToken() {
    const str = localStorage.getItem(authItemName) || sessionStorage.getItem(authItemName);
    if(!str) return null
    const authObj = JSON.parse(str)
    if(new Date(authObj.expire) <= new Date()) {
        deleteAccessToken()
        ElMessage.warning("登录状态已过期，请重新登录！")
        return null
    }
    return authObj.token
}


function internalPost(url, data, headers, success, failure, error = defaultError){
    api.post(url, data, { headers: headers }).then(({data}) => {
        if(data.code === 200)
            success(data.data)
        else
            failure(data.message, data.code, url)
    }).catch(err => error(err))
}

function internalGet(url, headers, success, failure, error = defaultError){
    api.get(url, { headers: headers }).then(({data}) => {
        if(data.code === 200)
            success(data.data)
        else
            failure(data.message, data.code, url)
    }).catch(err => error(err))
}
function login(username, password, remember, success, failure = defaultFailure){
    internalPost('/admin/auth/login', {
        username: username,
        password: password
    }, {
        'Content-Type': 'application/x-www-form-urlencoded'
    }, (data) => {
        storeAccessToken(remember, data.token, data.expire)
        const userStore = useUserStore()
        userStore.userInfo.username=data.username
        userStore.userInfo.role=data.role
        ElMessage.success(`登录成功，欢迎 ${data.username} 来到我们的系统`)
        success(data)
    }, failure)
}

function post(url, data, success, failure = defaultFailure) {
    internalPost(url, data, accessHeader() , success, failure)
}

function logout(success, failure = defaultFailure){
    get('/admin/auth/logout', () => {
        deleteAccessToken()
        ElMessage.success(`退出登录成功，欢迎您再次使用`)
        success()
    }, failure)
}

function deleatePost(id,success,failure=defaultFailure){
    const url = '/cms/blog/article/' + id;

    api.delete(url,{ headers: accessHeader()}).then(({data}) =>{
        if(data.code === 200)
            success(data.data)
        else
            failure(data.message, data.code, url)
    }).catch(err => defaultError(err))
}

function getPost(id,success,failure = defaultFailure){
    const url = '/api/blog/article/id/' + id;
    api.get(url).then(({data})=>{
        if(data.code === 200)
            success(data.data)
        else
            failure(data.message, data.code, url)
    }).catch(err => defaultError(err))
}


function getIntroduction(success,failure = defaultFailure){
    const url = '/api/blog/introduction';
    api.get(url).then(({data})=>{
        if(data.code === 200)
            success(data.data)
        else
            failure(data.message, data.code, url)
    }).catch(err => defaultError(err))
}
function newOrUpdatePost(data,success,failure=defaultFailure){
    const url = '/cms/blog/article/save'
    post(url,data,success,failure);

}
function UpdateIntroduction(data,success,failure=defaultFailure){
    const url = '/cms/blog/introduction/update'
    post(url,data,success,failure);

}
function getPostsList(current,pageSize,success){
    const url = '/api/blog/article?page='+current+'&limit='+pageSize
    get(url,success)
}
function getUserInfo(success,failure){
    const url='/cms/UserInfo'
    get(url,success,failure)

}

function get(url, success, failure = defaultFailure) {
    internalGet(url, accessHeader(), success, failure)
}

function unauthorized() {
    return !takeAccessToken()
}


export { post, get, login, logout, unauthorized,deleatePost,getPost,newOrUpdatePost,getPostsList,getUserInfo,getIntroduction,UpdateIntroduction }
