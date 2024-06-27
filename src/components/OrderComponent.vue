<template>
  <div>
    <h1>Orders</h1>
    <ul>
      <li v-for="order in orders" :key="order.id">
        {{ order.name }} - {{ order.price }} - {{ order.quantity }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      orders: []
    };
  },
  created() {
    this.fetchOrders();
  },
  methods: {
    fetchOrders() {
      axios.get('http://localhost:8080/orders')
          .then(response => {
            this.orders = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    }
  }
};
</script>
