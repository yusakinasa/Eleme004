<template>
  <div id="app" class="order-page">
    <header>
      <button class="logo-btn" @click="logoclick">
        <img src="@/assets/eleme-logo.png" alt="Eleme Logo" class="logo"/>
        <h1>ELEME</h1>
      </button>
      <button class="logout-btn" @click="logout">退出</button>
    </header>
    <section class="order-details">
      <h2>订单详情</h2>
      <div class="main-info">
        <div class="order-summary">
          <h3>订单已完成</h3>
          <p>感谢信任，期待再次光临</p>
          <div class="contact-info">
            <label>联系商家</label>
            <input type="text" value="15826506260" readonly/>
          </div>
        </div>
        <div class="order-items">
          <button class="shop-redirect-btn" @click="redirectToShop">氛气层（华科东校区店）></button>
          <div class="item">
            <span class="item-name">招牌咖喱鸡饭</span>
            <span class="item-price">¥19.9</span>
          </div>
          <div class="item">
            <span class="item-name">雪碧</span>
            <span class="item-price">¥5</span>
          </div>
          <div class="order-summary-total">
            <span class="total-label">总计</span>
            <span class="total-price">¥25.9</span>
          </div>
        </div>
      </div>
    </section>
    <section class="bottom-info">
      <section class="shipping-info">
        <h3>收货人信息</h3>
        <div class="info-line">
          <span class="label">收货人: </span>
          <span class="value">屈唯一</span>
        </div>
        <div class="info-line">
          <span class="label">地址:</span>
          <span class="value">湖北武汉市洪山区关山街道华中科技大学东校区韵苑宿舍16栋</span>
        </div>
        <div class="info-line">
          <span class="label">手机号码:</span>
          <span class="value">158*****6260</span>
        </div>
      </section>
      <section class="payment-info">
        <h3>付款信息</h3>
        <div class="info-line">
          <span class="label">付款方式:</span>
          <span class="value">在线支付</span>
        </div>
        <div class="info-line">
          <span class="label">付款时间:</span>
          <span class="value">2024-05-16 21:58:26</span>
        </div>
      </section>
    </section>
  </div>
</template>

<script>
export default {
  name: 'App',
  methods: {
    logoclick() {
      this.$router.push({name: 'ShopSelection'});
    },
    logout() {
      this.$router.push({name: 'Log'});
    },
    redirectToShop() {
      this.$router.push({name: 'ShopSelection'});
    }
  }
};
</script>

<style scoped>
.order-page {
  font-family: Arial, sans-serif;
  margin: 0 10%;
  padding: 20px;
}

header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 0;
}

h1 {
  margin: 10px;
  font-size: 24px;
  color: #333;
}

.logo {
  height: 40px;
}

.logo-btn {
  background: white;
  cursor: pointer;
  border: none;
  display: flex;
}

.logout-btn {
  background-color: #f44336;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
}

.shop-redirect-btn {
  background: white;
  border: none;
  cursor: pointer;
  margin-bottom: 10px;
  padding: 0;
  font-size: 20px;
  font-weight: bold;
}

.main-info {
  display: flex;
}


.order-details {
  margin: 20px 0 20px 0;
}

.order-summary {
  border: 1px solid #ddd;
  padding: 50px;
  margin-right: 10px;
  flex: 1;
}

.order-items {
  border: 1px solid #ddd;
  padding: 50px;
  margin-left: 10px;
  flex: 1;
}

.item-name {
  margin-left: 10px;
}

.order-summary-total {
  border: none;
  margin-right: 0;
  text-align: right;
}

.contact-info label {
  display: block;
  margin-bottom: 5px;
}

.contact-info input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
}

.item {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.total-label, .total-price {
  font-weight: bold;
}

.total-price {
  color: #f44336;
}

.shipping-info {
  margin: 20px;
  padding: 20px;
  flex: 1;
}

.payment-info {
  margin: 20px;
  padding: 20px;
  flex: 1;
}

.bottom-info {
  display: flex;
  border: 1px solid #ddd;
}

.info-line{
  display: flex;
}

.label {
  flex: 1;
  display: flex;
  font-weight: bold;
  margin: 10px;
  width: 60px;
}

.value {
  margin: 10px;
  flex: 1;
  word-wrap: break-word; /* 强制换行 */
  display: flex;
  text-align: left;
}
</style>
