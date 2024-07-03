<!-- OrderConfirmation.vue -->
<template>
  <div>
    <HeaderBar :showSearch="false" />

    <div class="order-confirmation">
      <h1>确认订单</h1>
      <div class="info">
        <div class="selectAddress">选择收货地址</div>
        <div class="shipping-info">
          <div class="address" v-if="!editingShippingInfo">
            地址：{{ selectedShippingInfo.address }} 联系人：{{ selectedShippingInfo.contactName }} 联系电话：{{ selectedShippingInfo.phoneNumber }}
          </div>
          <div v-else>
            <input type="text" v-model="newShippingInfo.address" placeholder="请输入地址">
            <input type="text" v-model="newShippingInfo.contactName" placeholder="请输入联系人姓名">
            <input type="text" v-model="newShippingInfo.phoneNumber" placeholder="请输入联系电话">
            <button @click="saveShippingInfo">保存</button>
            <button @click="cancelEditShippingInfo">取消</button>
          </div>
          <button class="moreAddress" @click="toggleAddressDropdown">{{ moreAddressesVisible ? '收起' : '更多' }}</button>
        </div>
      </div>

      <!-- 更多地址列表 -->
      <div v-if="moreAddressesVisible" class="more-addresses">
        <div v-for="(address, index) in addresses" :key="index" class="address-item">
          <label class="address-item-content">
            <input type="radio" :checked="index === selectedAddressIndex" @change="selectDefaultAddress(index)">
            <span>地址：{{ address.address }} 联系人：{{ address.contactName }} 联系电话：{{ address.phoneNumber }}</span>
          </label>
        </div>
        <button v-if="!addingNewAddress" class="add-new-address">
          <span @click="toggleAddingNewAddress">添加新地址</span>
        </button>
        <div v-if="addingNewAddress" class="add-new-address">
          <input type="text" v-model="newContactName" placeholder="联系人姓名">
          <input type="text" v-model="newPhoneNumber" placeholder="联系电话">
          <input type="text" v-model="newAddress" placeholder="请输入新地址">
          <button @click="addNewAddress">确定</button>
          <button @click="cancelAddAddress">取消</button>
        </div>
      </div>

      <!-- 主要内容区域 -->
      <div class="main-content">
        <!-- 配送时间选择器 -->
        <div class="delivery-time">
          <label>选择配送时间：</label>
          <ul>
            <li v-for="(option, index) in deliveryOptions" :key="index">
              <input type="radio" :value="option.value" v-model="selectedDeliveryTime">
              {{ option.label }}
            </li>
          </ul>
          <div v-if="selectedDeliveryTime" class="selected-time">
            已选配送时间：{{ selectedDeliveryTime }}
          </div>
        </div>

        <!-- 购物清单 -->
        <div class="shopping-list-container">
          <div class="shopping-list">
            <div class="store-info">
              氢气层(华科东校区店) - 商家自配送
            </div>
            <div class="item" v-for="(item, index) in shoppingCart" :key="index">
              <div class="item-info">
                {{ item.name }}
              </div>
              <div class="price">¥{{ item.price }}</div>
            </div>
          </div>
          <div class="subtotal">
            <div class="total">
              小计 ¥{{ calculateSubtotal() }}
            </div>
          </div>
        </div>
      </div>

      <!-- 支付方式 -->
      <div class="payment-method">
        <div class="payment-option">
          <input type="radio" id="alipay" name="paymentMethod" value="alipay" v-model="selectedPaymentMethod">
          <label for="alipay">
            <img src="../assets/alipay-logo.png" alt="支付宝Logo" class="payment-logo">
            <span class="payment-text">支付宝</span>
          </label>
        </div>
        <div class="payment-option">
          <input type="radio" id="wechatPay" name="paymentMethod" value="wechatPay" v-model="selectedPaymentMethod">
          <label for="wechatPay">
            <img src="../assets/wechatPay-logo.png" alt="微信支付Logo" class="payment-logo">
            <span class="payment-text">微信支付</span>
          </label>
        </div>
      </div>

      <!-- 提交按钮 -->
      <div class="submit-button">
        <button @click="submitOrder">提交订单</button>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue"; // 导入 HeaderBar 组件
import router from "@/router";
import axios from 'axios';

export default {
  name: 'OrderConfirmation',
  components: {
    HeaderBar, // 注册 HeaderBar 组件
  },
  data() {
    return {
      selectedDeliveryTime: '', // 初始化选中的配送时间
      deliveryOptions: [], // 存储配送时间选项的数组
      moreAddressesVisible: false, // 控制更多地址列表的显示状态
      addingNewAddress: false, // 控制添加新地址表单的显示状态
      addresses: [
        { contactName: '张三', phoneNumber: '123456789', address: '地址1' },
        { contactName: '李四', phoneNumber: '987654321', address: '地址2' },
        { contactName: '王五', phoneNumber: '135792468', address: '地址3' }
      ], // 示例地址列表
      selectedAddressIndex: 0, // 选中的地址索引
      selectedShippingInfo: {
        contactName: '张三',
        phoneNumber: '123456789',
        address: '地址1'
      }, // 选中的收货信息对象
      newContactName: '', // 新的联系人姓名
      newPhoneNumber: '', // 新的联系电话
      newAddress: '', // 新的地址
      selectedPaymentMethod: 'alipay', // 初始选择支付宝支付
      editingShippingInfo: false,
      newShippingInfo: {
        contactName: '张三',
        phoneNumber: '123456789',
        address: '地址1'
      }, // 默认收货信息对象
      shoppingCart: [
        { name: '葡国奶油焗饭+原味鸡块+雪碧', price: '29.9' },
        { name: '某某商品', price: '20' },
        { name: '新商品1', price: '15.5' },
        { name: '新商品2', price: '12.3' }
      ] // 购物车中的商品列表
    };
  },
  created() {
    this.generateDeliveryOptions();
  },
  methods: {
    generateDeliveryOptions() {
      const now = new Date();
      const currentTime = `${now.getHours()}:${now.getMinutes().toString().padStart(2, '0')}`;
      this.deliveryOptions = [
        { label: `立即送出（${currentTime}）`, value: '立即送出' }
      ];

      // Generate delivery options for the next few hours
      let hour = now.getHours();
      let minute = now.getMinutes() + 30; // Add 30 minutes
      for (let i = 0; i < 5; i++) {
        if (minute >= 60) {
          hour++;
          minute -= 60;
        }
        const timeLabel = `${hour}:${minute.toString().padStart(2, '0')}`;
        this.deliveryOptions.push({
          label: `${timeLabel}`,
          value: timeLabel
        });
        minute += 30;
      }

      this.selectedDeliveryTime = this.deliveryOptions[0].value; // 默认选择第一个选项
    },
    submitOrder() {
      // 准备发送到后端的数据
      const orderData = {
        shippingInfo: this.selectedShippingInfo,
        deliveryTime: this.selectedDeliveryTime,
        paymentMethod: this.selectedPaymentMethod,
        shoppingCart: this.shoppingCart
      };

      // 实际的后端API端点URL；替换为您的后端API端点
      const apiUrl = 'http://localhost:8080/';

      // 使用Axios发送POST请求到后端
      axios.post(apiUrl, orderData)
          .then(() => {
            alert('订单已提交');
            router.push({ name: 'PayComplete' });
          })
          .catch(error => {
            console.error('提交订单时出错:', error);
            alert('提交订单时出错，请重试。');
          });


    },
    toggleAddressDropdown() {
      this.moreAddressesVisible = !this.moreAddressesVisible;
    },
    toggleAddingNewAddress() {
      this.addingNewAddress = !this.addingNewAddress;
    },
    saveShippingInfo() {
      if (this.newShippingInfo.address.trim() !== '' && this.newShippingInfo.contactName.trim() !== '' && this.newShippingInfo.phoneNumber.trim() !== '') {
        this.editingShippingInfo = false;
        this.selectedShippingInfo = {
          address: this.newShippingInfo.address,
          contactName: this.newShippingInfo.contactName,
          phoneNumber: this.newShippingInfo.phoneNumber
        };
      }
    },
    cancelEditShippingInfo() {
      this.editingShippingInfo = false;
    },
    addNewAddress() {
      if (this.newContactName.trim() !== '' && this.newPhoneNumber.trim() !== '' && this.newAddress.trim() !== '') {
        this.addresses.push({
          contactName: this.newContactName,
          phoneNumber: this.newPhoneNumber,
          address: this.newAddress
        });
        this.newContactName = '';
        this.newPhoneNumber = '';
        this.newAddress = '';
        this.addingNewAddress = false;
        this.moreAddressesVisible = true;
      }
    },
    cancelAddAddress() {
      this.newContactName = '';
      this.newPhoneNumber = '';
      this.newAddress = '';
      this.addingNewAddress = false;
    },
    selectDefaultAddress(index) {
      this.selectedAddressIndex = index;
      this.selectedShippingInfo = {
        address: this.addresses[index].address,
        contactName: this.addresses[index].contactName,
        phoneNumber: this.addresses[index].phoneNumber
      };
      this.moreAddressesVisible = false; // 收起更多地址列表
    },
    calculateSubtotal() {
      let subtotal = 0;
      this.shoppingCart.forEach(item => {
        subtotal += parseFloat(item.price);
      });
      return subtotal.toFixed(2);
    }
  }
};
</script>


<style scoped>
.order-confirmation {
  font-family: Arial, sans-serif;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
}

.info {
  margin-bottom: 20px;
}

.selectAddress {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
}

.shipping-info {
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
}

.address-info label {
  flex: 0 0 80px; /* 固定标签宽度 */
  margin-right: 10px;
}

.address-info span {
  flex-grow: 1; /* 自动扩展内容区域 */
  display: inline-block;
}

.edit-shipping-info input {
  width: calc(100% - 20px);
  padding: 5px;
  margin-bottom: 5px;
}

.save-cancel-buttons button {
  margin-right: 10px;
}

.moreAddress {
  cursor: pointer;
  color: white;
}

.more-addresses {
  border: 1px solid #ccc;
  padding: 10px;
  margin-top: 10px;
  margin-bottom: 20px;
}

.add-new-address {
  margin-top: 10px;
}

.main-content {
  display: flex;
}

.delivery-time {
  flex: 1; /* 占据左侧空间 */
  margin-right: 20px; /* 可根据需要调整右侧间距 */
  padding: 10px; /* 添加内边距 */
  border: 1px solid #ccc; /* 添加边框样式 */
  margin-bottom: 20px; /* 底部外边距 */
}

.delivery-time label {
  font-weight: bold;
}

.delivery-time ul {
  list-style: none;
  padding: 0;
}

.delivery-time li {
  cursor: pointer;
  margin-bottom: 5px;
}

.selected-time {
  margin-top: 10px;
}

.shopping-list-container {
  flex: 2;
  border: 1px solid #ccc;
  padding: 10px;
  max-height: 218px; /* 调整为适当的高度 */
  overflow-y: auto;
  position: relative;
}

.shopping-list-container::after {
  content: '';
  position: absolute;
  top: 0;
  right: 0;
  width: 8px;
  background-color: #f0f0f0;
  border-left: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  bottom: 0;
  z-index: 1;
}

.store-info {
  font-weight: bold;
  margin-bottom: 10px;
}

.item {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.item-info {
  flex-grow: 1;
}

.price {
  font-weight: bold;
}

.subtotal {
  border-top: 1px dashed #ccc;
  padding-top: 10px;
  margin-top: 10px;
  background-color: #fff;
  position: sticky;
  bottom: 0;
}

.total {
  font-weight: bold;
  margin-top: 10px;
}


.payment-method {
  display: flex;
  justify-content: space-evenly; /* 或者 space-around，根据需要选择 */
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 20px;
}

.payment-option {
  display: flex;
  align-items: center; /* 垂直居中对齐 */
}

.payment-logo {
  width: 50px; /* 调整图片宽度 */
  height: auto; /* 保持高度自适应 */
  margin-right: 10px;
}

.payment-text {
  font-size: 16px; /* 根据需要调整文字大小 */
  line-height: 50px; /* 与图片高度相同，确保垂直居中对齐 */
}

.submit-button {
  text-align: center;
  margin-bottom: 20px;
}

button {
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: 1px solid;
  border-radius: 8px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
