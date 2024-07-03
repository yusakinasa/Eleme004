<template>
  <div class="eleme-page">
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
        <img :src="store.imageurl" alt="店铺图片" class="store-image">
        <div class="store-info">
          <h2 class="store-name">{{ store.name }}</h2>
          <div class="store-details">
            <span class="store-rating">{{ store.rating }}分</span>
            <span class="monthly-sales">月售{{ store.sales }}+</span>
            <span class="distance">{{ store.distance }}km</span>
            <span class="avg-price">均价{{ store.avgprice }}元</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ElemePage',
  data() {
    return {
      buttons: [
        { label: '评分↓', isActive: false, order: 'desc' },
        { label: '人气↓', isActive: false, order: 'desc' },
        { label: '距离↓', isActive: false, order: 'desc' },
        { label: '人均价↑', isActive: false, order: 'asc' }
      ],
      stores: []  // 初始化为空，数据将从服务器获取
    };
  },
  methods: {
    handleClick(index) {
      this.buttons.forEach((button, i) => {
        if (i === index) {
          if (button.isActive===true){
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
  background-color: #f0f0f0;
  text-align: center;
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

.username {
  margin-right: 8px;
}

.user-tag {
  background-color: yellow;
  padding: 4px 8px;
  border-radius: 4px;
}

.order-history-button {
  margin-left: 16px;
  padding: 8px 16px;
  background-color: #ff9800;
  border: none;
  color: white;
  border-radius: 4px;
  cursor: pointer;
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
}

/* 激活状态下的样式 */
.nav-button.active {
  background-color: #007bff; /* 保持蓝色 */
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
  margin: 0;
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
</style>
