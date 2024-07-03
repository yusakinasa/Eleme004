<template>
  <div>
    <!-- 顶部用户信息和搜索框 -->
        <header class="header">
          <div class="logo">
            <img src="logo.png" alt="ELEME">
            <span>ELEME</span>
          </div>
          <div class="search-bar">
            <input type="text" placeholder="搜索">
            <button>搜索</button>
          </div>
          <div class="user-info">
            <span>user256</span>
            <button>退出</button>
          </div>
        </header>
    <h2>我的订单</h2>
    <div class="order-list">
      <div class="order" v-for="order in orders" :key="order.id">
        <img :src="order.image" alt="order image" />
        <div class="order-info">
          <p>{{ order.name }}</p>
          <p>{{ order.date }}</p>
        </div>
        <div class="order-details">
          <p>收货人: {{ order.recipient }}</p>
          <p>金额: {{ order.amount }}</p>
          <p>支付方式: {{ order.payment }}</p>
        </div>
        <div class="order-actions">
          <button @click="viewOrder(order.id)">订单详情</button>
          <button @click="deleteOrder(order.id)">删除</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      orders: [
        {
          id: 1,
          image: 'image_url',
          name: '炸鸡（华科店）',
          date: '2024-06-30 17:30',
          recipient: '屈唯一',
          amount: '¥50.0',
          payment: '微信支付',
        },
        {
          id: 2,
          image: 'image_url',
          name: '炸鸡（华科店）',
          date: '2024-06-30 17:30',
          recipient: '屈唯一',
          amount: '¥20.0',
          payment: '微信支付',
        },
      ],
    };
  },
  methods: {
    viewOrder(id) {
      // 实现订单详情查看功能
      this.$router.push(`/order-detail`);
      console.log(`查看订单 ${id}`);
    },
    deleteOrder(id) {
      // 实现订单删除功能
      this.orders = this.orders.filter(order => order.id !== id);
    },
  },
};
</script>

<style>
.order-list {
  margin-top: 20px;
}
.order {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
}
.order-info, .order-details, .order-actions {
  margin: 0 10px;
}

.order-actions button {
  margin-left: 10px;
}

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: white;
  padding: 16px;
  margin-bottom: 16px;
  border-radius: 8px;
}

.logo {
  width: 100px;
}

.search-bar {
  display: flex;
  align-items: center;
}

.search-bar input {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.search-bar button {
  padding: 0.5rem;
  margin-left: 0.5rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.user-info {
  display: flex;
  align-items: center;
}

.user-info button {
  margin-left: 0.5rem;
  padding: 0.5rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

</style>
