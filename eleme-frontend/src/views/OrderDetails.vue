<template>
  <div id="app" class="order-page">
    <header>
      <img src="eleme-logo.png" alt="Eleme Logo" class="logo" />
      <button class="logout-btn">退出</button>
    </header>
    <section class="order-details">
      <h2>订单详情</h2>
      <div class="order-summary">
        <h3>订单已完成</h3>
        <p>感谢信任，期待再次光临</p>
        <div class="contact-info">
          <label>联系商家</label>
          <input type="text" value="15826506260" readonly />
        </div>
      </div>
      <div class="order-items">
        <button class="shop-redirect-btn">氛气层（华科东校区店）></button>
        <div class="item">
          <span class="item-name">招牌咖喱鸡饭</span>
          <span class="item-price">¥19.9</span>
        </div>
        <div class="item">
          <span class="item-name">雪碧</span>
          <span class="item-price">¥5</span>
        </div>
      </div>
      <div class="order-summary-total">
        <div class="total-label">总计</div>
        <div class="total-price">¥25.9</div>
      </div>
    </section>
    <section class="shipping-info">
      <h3>收货人信息</h3>
      <p>收货人：屈唯一</p>
      <p>地址：湖北武汉市洪山区关山街道华中科技大学东校区韵苑宿舍16栋</p>
      <p>手机号码：158*****6260</p>
    </section>
    <section class="payment-info">
      <h3>付款信息</h3>
      <p>付款方式：在线支付</p>
      <p>付款时间：2024-05-16 21:58:26</p>
    </section>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style scoped>
.order-page {
  font-family: Arial, sans-serif;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}

header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 0;
}

.logo {
  height: 40px;
}

.logout-btn {
  background-color: #f44336;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
}

.shop-redirect-btn {
  background :white;
  border: none;
  cursor: pointer;
  font-size: 20px;
  font-weight: bold;
}

.order-details, .shipping-info, .payment-info {
  margin: 20px 0;
}

.order-summary, .order-items, .order-summary-total {
  border: 1px solid #ddd;
  padding: 15px;
  margin: 10px 0;
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
</style>
