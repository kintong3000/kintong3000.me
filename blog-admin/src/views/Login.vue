<script setup>
import ToggleDarkSwitch from "@/components/toggleDarkSwitch.vue";
import {reactive} from "vue";
import {ref} from "vue";
import {login} from "@/net/index.js";
import router from "@/router/index.js";

const formRef = ref()
const form = reactive({
  username: '',
  password: '',
  remember: false
})

const rules = {
  username: [
    {required: true, message: '请输入用户名'}
  ],
  password: [
    {required: true, message: '请输入密码'}
  ]
}

function userLogin() {
  formRef.value.validate((isValid) => {
    if(isValid) {
      login(form.username, form.password, form.remember, () => router.push("/"))
    }
  });
}
</script>

<template>
  <div class="relative">
    <div class=" absolute top-4 right-4 ">
      <ToggleDarkSwitch class="cursor-pointer"/>
    </div>
    <div class="flex flex-nowrap h-screen">
      <div class="hidden xl:flex flex-col justify-center w-3/5 login-bg">

        <div class="-mt-16 ">
          <!--        <img-->
          <!--            :alt="title"-->
          <!--            src="@/assets/login-box-bg.svg"-->
          <!--            class="w-90 -mt-16 "-->
          <!--        />-->
          <div class="text font-sans	text-4xl font-bold  pl-20	 login-text">后台管理系统</div>
          <div class="text font-sans	text-4xl font-bold  pl-20	login-text"> Content Management System</div>
        </div>
      </div>


      <div class="flex-auto flex flex-col justify-center">
        <div class=" mx-auto w-full -mt-36">
          <div class="text text-3xl font-bold mx-auto" style="max-width: 300px">登录</div>

          <el-form :model="form" class="mt-4 mx-auto" style="max-width: 300px" :rules="rules" ref="formRef">
            <el-form-item prop="username">
              <el-input size="large" maxlength="10" type="text" v-model="form.username" placeholder='用户名'/>
            </el-form-item>
            <el-form-item prop="password">
              <el-input size="large"  type="password"  maxlength="20" v-model="form.password" placeholder='密码'/>
            </el-form-item>
            <el-row style="margin-top: 5px">
              <el-col :span="12" style="text-align: left">
                <el-form-item prop="remember">
                  <el-checkbox v-model="form.remember" label="记住我"/>
                </el-form-item>
              </el-col>
            </el-row>
            <el-form-item>
              <el-button size="large" type="primary" @click="userLogin()">登录</el-button>
            </el-form-item>

          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.login-bg {
  background-color: #b3e76d;
}

.dark .login-bg {
  background-color: #00002E;
}

.dark .login-text {
  color: #D292FF;
}

.login-text {
  color: #104fee;
}

.el-button--primary,.el-checkbox {
  --el-button-bg-color: #3C46FF;
  --el-color-primary: #3C46FF;
}
</style>
