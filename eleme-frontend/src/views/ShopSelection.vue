<template>
    <!-- 使用 HeaderBar 组件 -->
  <HeaderBar
        :username="username"
        @logo-click="onLogoClick"
        @search="onSearch"
        @view-orders="onViewOrders"
        @logout="onLogout"
    />
  <div class="eleme-page">
    <nav class="navigation">
      <button
          v-for="(button, index) in buttons"
          :key="index"
          :class="{ active: button.isActive }"
          @click="handleClick(index)"
          class="nav-button"
      >
        {{ button.label }}
      </button>
    </nav>

    <div class="store-list">
      <div v-for="(store, index) in stores" :key="index" class="store-item">
        <img :src="store.image" alt="店铺图片" class="store-image">
        <div class="store-info">
          <h2 class="store-name">{{ store.name }}</h2>
          <div class="store-details">
            <span class="store-rating">{{ store.rating }}分</span>
            <span class="monthly-sales">月售{{ store.sales }}+</span>
            <span class="distance">{{ store.distance }}km</span>
            <span class="avg-price">¥{{ store.avg_price }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderBar from '@/components/HeaderBar.vue';

export default {
  name: 'ElemePage',
  components: {
    HeaderBar
  },
  data() {
    return {
      username: 'user256',
      buttons: [
        { label: '评分↓', isActive: false, order: 'desc' },
        { label: '人气↓', isActive: false, order: 'desc' },
        { label: '距离↓', isActive: false, order: 'desc' },
        { label: '人均价↑', isActive: false, order: 'asc' }
      ],
      stores: [
        {
          name: '安格斯牛肉拌饭（华科东校区店）',
          rating: 4.7,
          sales: 2000,
          distance: 1.5,
          avg_price: 50,
          image: '//path-to-store-image.png'
        },
        {
          name: '安格斯牛肉拌饭（华科东校区店）',
          rating: 4.7,
          sales: 2000,
          distance: 1.5,
          avg_price: 50,
          image: '//path-to-store-image.png'
        },
        {
          name: '安格斯牛肉拌饭（华科东校区店）',
          rating: 4.7,
          sales: 2000,
          distance: 1.5,
          avg_price: 50,
          image: '//path-to-store-image.png'
        },
      ]// stores: []  // 初始化为空，数据将从服务器获取
    };
  },
  methods: {
    handleClick(index) {
      this.buttons.forEach((button, i) => {
        if (i === index) {
          if (button.isActive === true) {
            button.order = button.order === 'asc' ? 'desc' : 'asc';
            button.label = `${button.label.slice(0, -1)}${button.order === 'asc' ? '↑' : '↓'}`;
          }
          button.isActive = true;
        } else {
          button.isActive = false;
        }
      });
    },
    fetchStores() {
      fetch('http://localhost:8081/business/all')
          .then(response => response.json())
          .then(data => {
            console.log(data); // 打印数据
            this.stores = data.data;
          })
          .catch(error => {
            console.error('Error fetching stores:', error);
          });
    },
    onLogoClick() {
      console.log('Logo clicked!');
    },
    onSearch(query) {
      console.log('Search query:', query);
    },
    onViewOrders() {
      console.log('View orders clicked!');
    },
    onLogout() {
      console.log('Logout clicked!');
    }
  },
  created() {
    this.fetchStores();
  }
};
</script>

<style scoped>
.eleme-page {
  padding: 16px;
  background-color: white;
  text-align: center;
}

.navigation {
  display: flex;
  justify-content: center;
  margin-bottom: 16px;
}

.nav-button {
  margin: 0 8px;
  padding: 8px 16px;
  background-color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  transition: background-color 0.3s ease; /* 添加平滑的背景颜色过渡效果 */
}

/* 鼠标悬停时的颜色渐变效果 */
.nav-button:hover {
  background-color: #007bff; /* 设置悬停时的背景颜色，可以根据需要修改 */
  color: white;
}

/* 激活状态下的样式 */
.nav-button.active {
  background-color: #007bff; /* 保持蓝色 */
  color: white;
}

.store-list {
  margin: 0 20%;
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.store-item {
  display: flex;
  align-items: center;
  background-color: white;
  padding: 16px;
  border-radius: 8px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  border: 1px solid;
}

.store-image {
  width: 80px;
  height: 80px;
  border-radius: 4px;
  margin-right: 16px;
}

.store-info {
  flex-grow: 1;
  text-align: left;
}

.store-name {
  font-size: 18px;
  margin-bottom: 8px;
}

.store-details {
  display: flex;
  gap: 16px;
}

.store-rating,
.monthly-sales,
.distance,
.avg-price{
  font-size: 14px;
}

/* 原来的 header 样式已经被移动到 HeaderBar 组件中 */
/* 其他样式保持不变 */
</style>
