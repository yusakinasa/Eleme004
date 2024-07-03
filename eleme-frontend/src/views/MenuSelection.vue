<template>
  <div class="eleme-page">
    <!-- 使用 HeaderBar 组件 -->
    <HeaderBar :username="username" />

    <!-- 主内容区域 -->
    <div class="content">
      <!-- 左边展示区域 -->
      <div class="left-view">
        <div class="shop-info-container">
          <div class="shop-info">
            <h2>仙踪小鹿(江汉路步行街店)</h2>
            <p>地址: 江汉一路19号某某地层261-64室</p>
            <p>电话: 18671153965</p>
            <p>评分: 4.7 | 人均: 84元 | 月销量: 2000+单</p>
            <p>公告: 欢迎光临本店，祝您用餐愉快！</p>
          </div>
          <div class="shop-image">
            <img src="shop.jpg" alt="shop">
          </div>
        </div>
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
          <div v-if="currentTab === '推荐菜'" class="recommendation-section">
            <div class="menu-items">
              <div class="menu-item" v-for="item in menuItems" :key="item.id">
                <img :src="item.image" alt="item.name">
                <div class="item-details">
                  <h3>{{ item.name }}</h3>
                  <p>¥{{ item.price }}</p>
                  <div class="quantity-control">
                    <button @click="decreaseQuantity(item)">-</button>
                    <span>{{ item.quantity }}</span>
                    <button @click="increaseQuantity(item)">+</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div v-else class="other-section">
            <p>{{ currentTab }}内容展示</p>
          </div>
        </div>
      </div>

      <!-- 购物车区域 -->
      <div class="cart">
        <h3>已选商品</h3>
        <div class="cart-items">
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
        </div>
        <div class="total">
          <span>共计 {{ totalPrice }} ¥</span>
          <button @click="RedirectToOrder">去结算</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderBar from '@/components/HeaderBar.vue';

export default {
  name: 'MenuSelection',
  components: {
    HeaderBar,
  },
  data() {
    return {
      username: 'user256', // 使用固定的用户名作为示例
      tabs: ['推荐菜', '环境', '价目表', '官方相册', '品牌故事', '食品安全档案'],
      currentTab: '推荐菜',
      menuItems: [
        {
          id: 1,
          name: '【经典】自选5件套',
          price: 25,
          image: 'item1.png',
          quantity: 0,
        },
        {
          id: 2,
          name: '【特价】招牌鸡翅',
          price: 10,
          image: 'item2.png',
          quantity: 0,
        },
        {
          id: 3,
          name: '【新品】炸鸡汉堡',
          price: 20,
          image: 'item3.png',
          quantity: 0,
        },
        {
          id: 4,
          name: '【新品】薯条',
          price: 30,
          image: 'item4.png',
          quantity: 0,
        },
        {
          id: 5,
          name: '【新品】鸡肉卷',
          price: 40,
          image: 'item5.png',
          quantity: 0,
        },
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
    RedirectToOrder() {
      this.$router.push({ name: 'OrderDetails' });
    }
  },
};
</script>

<style scoped>
.content {
  display: flex;
  flex: 1;
  overflow: hidden;
}

.left-view {
  flex: 3;
  padding: 1rem;
  overflow-y: auto;
}

.menu-tabs {
  display: flex;
  margin-bottom: 1rem;
}

.menu-tabs span {
  margin-right: 1rem;
  cursor: pointer;
}

.menu-tabs .active {
  font-weight: bold;
}

.menu-content {
  background-color: #f0f0f0; /* 灰色背景 */
  padding: 20px;
  border-radius: 8px;
}

.menu-items {
  display: flex;
  flex-wrap: wrap;
  gap: 20px; /* 间距 */
}

.menu-item {
  flex: 1 1 calc(40% - 20px); /* 每行两个 */
  background-color: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  overflow: hidden;
  text-align: center;
  padding: 1rem;
}

.menu-item img {
  width: 100%;
  height: auto;
}

.menu-item .item-details {
  margin-top: 0.5rem;
}

.cart {
  flex: 1;
  padding: 1rem;
  background-color: #f8f8f8;
  border-left: 1px solid #e0e0e0;
  display: flex;
  flex-direction: column;
}

.cart-items {
  flex: 1;
  overflow-y: auto;
}

.cart-item {
  display: flex;
  align-items: center;
  padding: 0.5rem 0;
}

.cart-item img {
  height: 50px;
  margin-right: 1rem;
}

.cart .total {
  display: flex;
  justify-content: space-between;
  padding-top: 1rem;
}

.quantity-control button {
  margin: 0 0.5rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.shop-info-container {
  display: flex;
  align-items: flex-start;
}

.shop-info {
  flex: 1;
}

.shop-img img {
  width: 100%;
  height: auto;
  border-radius: 8px;
}
</style>
