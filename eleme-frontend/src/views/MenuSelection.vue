<template>
  <div class="menu-selection">
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
        <button>我的订单</button>
        <button>退出</button>
      </div>
    </header>

    <!-- 店铺信息 -->
    <div class="shop-info">
      <h2>仙踪小鹿(江汉路步行街店)</h2>
      <p>地址: 江汉一路19号某某地层261-64室</p>
      <p>电话: 18671153965</p>
      <p>评分: 4.7 | 人均: 84元</p>
    </div>

    <!-- 菜品列表 -->
    <div class="menu">
      <div class="menu-tabs">
        <span
          v-for="tab in tabs"
          :key="tab"
          :class="{ active: currentTab === tab }"
          @click="currentTab = tab"
        >
          {{ tab }}
        </span>
      </div>
      <div class="menu-content">
        <div v-if="currentTab === '推荐菜'">
          <div class="menu-item" v-for="item in menuItems" :key="item.id">
            <img :src="item.image" alt="item.name">
            <div class="item-details">
              <h3>{{ item.name }}</h3>
              <p>{{ item.description }}</p>
              <p>¥{{ item.price }}</p>
              <div class="quantity-control">
                <button @click="decreaseQuantity(item)">-</button>
                <span>{{ item.quantity }}</span>
                <button @click="increaseQuantity(item)">+</button>
              </div>
            </div>
          </div>
        </div>
        <div v-else>
          <p>{{ currentTab }}内容展示</p>
        </div>
      </div>
    </div>

    <!-- 已选商品和总价 -->
    <div class="cart">
      <h3>已选商品</h3>
      <div class="cart-item" v-for="item in cartItems" :key="item.id">
        <img :src="item.image" alt="item.name">
        <div class="item-details">
          <h4>{{ item.name }}</h4>
          <p>¥{{ item.price }} x {{ item.quantity }}</p>
          <div class="quantity-control">
            <button @click="decreaseQuantity(item)">-</button>
            <span>{{ item.quantity }}</span>
            <button @click="increaseQuantity(item)">+</button>
          </div>
        </div>
      </div>
      <div class="total">
        <span>共计 {{ totalPrice }} ¥</span>
        <button>去结算</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MenuSelection',
  data() {
    return {
      tabs: ['推荐菜', '环境', '价目表', '官方相册', '品牌故事', '食品安全档案'],
      currentTab: '推荐菜',
      menuItems: [
        {
          id: 1,
          name: '【经典】自选5件套',
          description: '描述...',
          price: 25.3,
          image: 'item1.png',
          quantity: 0,
        },
        // 添加更多菜品信息
      ],
      cartItems: [],
    };
  },
  computed: {
    totalPrice() {
      return this.cartItems.reduce((total, item) => total + item.price * item.quantity, 0);
    },
  },
  methods: {
    increaseQuantity(item) {
      item.quantity++;
      if (!this.cartItems.includes(item)) {
        this.cartItems.push(item);
      }
    },
    decreaseQuantity(item) {
      if (item.quantity > 0) {
        item.quantity--;
        if (item.quantity === 0) {
          const index = this.cartItems.indexOf(item);
          if (index !== -1) {
            this.cartItems.splice(index, 1);
          }
        }
      }
    },
  },
};
</script>

<style scoped>
/* 添加你的样式 */
.menu-selection {
  display: flex;
  flex-direction: column;
  font-family: Arial, sans-serif;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
  background-color: #f5f5f5;
}

.logo {
  display: flex;
  align-items: center;
}

.logo img {
  height: 50px;
  margin-right: 10px;
}

.search-bar {
  display: flex;
  align-items: center;
}

.search-bar input {
  width: 200px;
  padding: 0.5rem;
  margin-right: 10px;
}

.user-info {
  display: flex;
  align-items: center;
}

.user-info span {
  margin-right: 10px;
}

.user-info button {
  margin-left: 10px;
}

.shop-info {
  padding: 1rem;
  background-color: #fff;
  border-bottom: 1px solid #e0e0e0;
}

.menu {
  display: flex;
  flex-direction: column;
  padding: 1rem;
}

.menu-tabs {
  display: flex;
  justify-content: space-around;
  padding: 1rem;
  background-color: #f5f5f5;
  border-bottom: 1px solid #e0e0e0;
}

.menu-tabs span {
  cursor: pointer;
}

.menu-tabs .active {
  font-weight: bold;
  border-bottom: 2px solid #000;
}

.menu-content {
  padding: 1rem;
}

.menu-item {
  width: calc(25% - 2rem);
  margin: 1rem;
  padding: 1rem;
  background-color: #fff;
  border: 1px solid #e0e0e0;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.menu-item img {
  width: 100%;
  height: auto;
  margin-bottom: 10px;
}

.item-details {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.item-details h3 {
  margin: 10px 0;
}

.quantity-control {
  display: flex;
  align-items: center;
  margin-top: 10px;
}

.quantity-control button {
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.quantity-control span {
  margin: 0 10px;
  width: 30px;
  text-align: center;
}

.cart {
  padding: 1rem;
  background-color: #fff;
  border-top: 1px solid #e0e0e0;
}

.cart-item {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.cart-item img {
  width: 50px;
  height: auto;
  margin-right: 10px;
}

.item-details {
  flex: 1;
}

.total {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
  background-color: #f5f5f5;
}
</style>
