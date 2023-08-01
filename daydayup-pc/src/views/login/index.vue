<template>
    <div class="login-container">
        <video src="@/assets/login/loginBg.mp4" autoplay loop />
        <div class="login-form">
            <header>
                <img src="@/assets/logo.jpg" />
                <h3>天天向上</h3>
            </header>
            <el-form ref="loginFormRef" :model="loginForm" status-icon :rules="rules">
                <el-form-item prop="account">
                    <el-input v-model="loginForm.account" type="text" placeholder="account" :prefix-icon="User"
                        autocomplete="off" />
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="loginForm.password" type="password" placeholder="password" :prefix-icon="Lock"
                        autocomplete="off" />
                </el-form-item>
                <el-form-item class="btn">
                    <el-button type="primary" @click="submitForm(loginFormRef)">登录</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import type { FormInstance, FormRules } from 'element-plus'
import { User, Lock } from '@element-plus/icons-vue'
import { teacherList } from '@/axios/daydayupApi'

const loginFormRef = ref<FormInstance>()
const router = useRouter();

const loginForm = reactive({
    account: '',
    password: ''
})

// 校验账号
const validateAccount = (rule: any, value: any, callback: any) => {
    if (value === '') {
        callback(new Error('account can\'t be empty'))
    }
    callback()
}

// 校验密码
const validatePass = (rule: any, value: any, callback: any) => {
    if (value === '') {
        callback(new Error('password can\'t be empty'))
    }
    callback()
}

// 校验规则
const rules = reactive<FormRules<typeof loginForm>>({
    account: [{ validator: validateAccount, trigger: 'blur' }],
    password: [{ validator: validatePass, trigger: 'blur' }],
})

// 点击登录
const submitForm = (formRef: FormInstance | undefined) => {
    if (!formRef) return
    formRef.validate((valid) => {
        if (valid) {
            userLogin()
        } else {
            console.log('error submit!')
            return false
        }
    })
}

// 后台登录
const userLogin = (() => {

    teacherList(loginForm).then((res) => {
        console.log(res)
    })


    // router.push({
    //     path: '/index'
    // })
})
</script>

<style lang="scss">
.login-container {
    width: 100vw;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;

    video {
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        width: 100%;
        height: 100%;
        object-fit: fill;
        z-index: -1
    }

    .login-form {
        display: flex;
        width: 380px;
        height: 380px;
        padding: 10vh;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        background: url("@/assets/login/loginFormBg.png");
        background-size: 100% 100%;
        border-radius: 10px;
        box-shadow: 0 2px 8px #f7f3f30f;
        opacity: "0.2";

        header {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 70px;

            img {
                display: inline-block;
                width: 40px
            }

            h3 {
                margin-bottom: 0;
                font-size: 18px;
                color: #fff;
                text-align: center
            }
        }

        .btn {
            display: flex;
            justify-content: center;
            align-items: center;

            button {
                width: 100%;
            }
        }

        .el-form-item {
            display: flex;
            flex-wrap: nowrap;
            border-radius: 5px;
            color: #454545
        }

        .el-input__wrapper {
            background-color: transparent !important;

            input {
                padding: 18px 22px
            }

            input:-webkit-autofill {
                box-shadow: 0 0 0 1000px #2d3a4b inset !important;
                -webkit-text-fill-color: #fff !important
            }
        }
    }
}
</style> 