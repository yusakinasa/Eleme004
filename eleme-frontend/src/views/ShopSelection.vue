<template>
  <div class="eleme-page">
    <header class="header">
      <div class="logo">
        <img src="logo.png" alt="ELEME">
        <span>ELEME</span>
      </div>
      <div class="search-bar">
        <input type="text" placeholder="搜索" v-model="searchQuery">
        <button @click="searchStores">搜索</button>
      </div>
      <div class="user-info">
        <span>{{ userPhone }}</span>
        <button>我的订单</button>
        <button @click="logout">退出</button>
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
      <div v-if="filteredStores.length === 0">没有找到匹配的商家</div>
      <div v-for="(store, index) in filteredStores" :key="index" class="store-item" @click="navigateToMenu(store.businessid)">
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
        { label: '评分↓', isActive: false, order: 'desc', field: 'rating' },
        { label: '人气↓', isActive: false, order: 'desc', field: 'sales' },
        { label: '距离↓', isActive: false, order: 'desc', field: 'distance' },
        { label: '人均价↑', isActive: false, order: 'asc', field: 'avgprice' }
      ],
      stores: [],
      userPhone: '',
      searchQuery: '',
      filteredStores: []
    };
  },
  methods: {
    navigateToMenu(businessid) {
      console.log('Navigating to MenuSelection with businessid:', businessid);
      // 添加条件以确保 businessid 是有效的
      if (businessid) {
        this.$router.push({ name: 'MenuSelection', query: { businessid } });
      } else {
        console.error('Invalid businessid:', businessid);
      }
    },


    handleClick(index) {
      this.buttons.forEach((button, i) => {
        if (i === index) {
          button.isActive = true;
          button.order = button.order === 'asc' ? 'desc' : 'asc';
          button.label = `${button.label.slice(0, -1)}${button.order === 'asc' ? '↑' : '↓'}`;
          this.fetchStores(button.field, button.order);
        } else {
          button.isActive = false;
        }
      });
    },
    fetchStores(sortField = 'rating', sortOrder = 'desc') {
      fetch(`http://localhost:8081/business/all?sortField=${sortField}&sortOrder=${sortOrder}`)
          .then(response => response.json())
          .then(data => {
            console.log(data);
            this.stores = data.data;
            this.filteredStores = this.stores;
          })
          .catch(error => {
            console.error('Error fetching stores:', error);
          });
    },
    searchStores() {
      if (this.searchQuery.trim() === '') {
        this.filteredStores = this.stores;
      } else {
        const query = this.searchQuery.toLowerCase();
        this.filteredStores = this.stores.filter(store =>
            store.name.toLowerCase().includes(query)
        );
      }
    },
    logout() {
      localStorage.removeItem('userPhone');
      this.$router.push({ name: 'LogIn' });
    }
  },
  created() {
    this.fetchStores();
    this.userPhone = localStorage.getItem('userPhone');
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
  transition: background-color 0.3s ease;
}

.nav-button:hover {
  background-color: #007bff;
}

.nav-button.active {
  background-color: #007bff;
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


