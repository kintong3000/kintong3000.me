import axios from "axios";
import config from "@/config/axiosConfig.js"


const api = axios.create({
    baseURL: config.api
});


function getArticleList(){
    const url='/api/blog/article?page=1&limit=100'
    api.get(url).then(({data}) => {
        if(data.code === 200)
            success(data.data)
        else
            failure(data.message, data.code, url)
    }).catch(err => error(err))
}

