<template>
  <div>
    <!-- 使用 HeaderBar 组件 -->
    <HeaderBar :username="username" :showSearch="true" />
  <div class="myorder-page">
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
          <button @click="viewOrder(order.orderid)">订单详情</button>
          <button @click="deleteOrder(order.orderid)">删除</button>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import HeaderBar from '@/components/HeaderBar.vue'; // 引入 HeaderBar 组件

export default {
  components: {
    HeaderBar
  },
  data() {
    return {
      username: 'user256',
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
    viewOrder(orderid) {
      // 实现订单详情查看功能
      this.$router.push({name:'OrderDetails'});
      console.log(`查看订单 ${id}`);
    },
    deleteOrder(orderid) {
      // 实现订单删除功能
      this.orders = this.orders.filter(order => order.orderid !== orderid);
    },

  },

};
</script>

<style>
.myorder-page {
  font-family: Arial, sans-serif;
  margin: 0 10%;
  padding: 20px;
}

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
</style>
