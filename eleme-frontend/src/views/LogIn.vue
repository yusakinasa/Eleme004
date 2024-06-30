<template>
  <div class="login-register-wrapper">
    <div class="login-register-container">
      <div class="logo">
        <img src="path/to/logo.png">
        <h1>ELEME</h1>
      </div>
      <div class="tab-buttons">
        <button :class="{ active: isLogin }" @click="toggleForm(true)">登录</button>
        <button :class="{ active: !isLogin }" @click="toggleForm(false)">注册</button>
      </div>
      <div v-if="isLogin" class="form-container">
        <input type="text" placeholder="手机号" v-model="loginPhone">
        <input type="password" placeholder="密码" v-model="loginPassword">
        <button @click="handleLogin">登录</button>
      </div>
      <div v-else class="form-container">
        <input type="text" placeholder="请输入手机号" v-model="registerPhone">
        <input type="password" placeholder="8-16位（大写字母+小写字母+数字）密码" v-model="registerPassword">
        <div class="verification-container">
          <input type="text" placeholder="请输入手机验证码" v-model="registerCode">
          <span class="get-code" @click="handleGetCode">获取验证码</span>
        </div>
        <button @click="handleRegister">注册</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LogIn',
  data() {
    return {
      isLogin: true,
      loginPhone: '',
      loginPassword: '',
      registerPhone: '',
      registerPassword: '',
      registerCode: ''
    }
  },
  methods: {
    toggleForm(isLogin) {
      this.isLogin = isLogin;
    },
    handleLogin() {
      // 登录处理逻辑
      console.log('登录:', this.loginPhone, this.loginPassword);
    },
    handleRegister() {
      // 注册处理逻辑
      console.log('注册:', this.registerPhone, this.registerPassword, this.registerCode);
    },
    handleGetCode() {
      // 获取验证码逻辑
      console.log('获取验证码:', this.registerPhone);
    }
  }
}
</script>

<style scoped>
.login-register-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f5f5;
}

.login-register-container {
  background-color: white;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  width: 320px;
  text-align: center;
}

.logo {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
}

.logo img {
  width: 50px;
  height: 50px;
  margin-right: 10px;
}

.logo h1 {
  font-size: 24px;
  margin: 0;
}

.tab-buttons {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.tab-buttons button {
  margin: 0 10px;
  padding: 10px 20px;
  border: none;
  background-color: #f0f0f0;
  cursor: pointer;
  border-radius: 5px;
}

.tab-buttons button.active {
  background-color: #007bff;
  color: white;
}

.form-container {
  display: flex;
  flex-direction: column;
}

.form-container input {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: calc(100% - 22px);
}

.form-container button {
  padding: 10px;
  border: none;
  background-color: #007bff;
  color: white;
  cursor: pointer;
  border-radius: 5px;
}

.verification-container {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.verification-container input {
  flex-grow: 1;
}

.get-code {
  padding: 10px;
  background-color: transparent;
  color: #007bff;
  cursor: pointer;
  white-space: nowrap;
}
</style>

