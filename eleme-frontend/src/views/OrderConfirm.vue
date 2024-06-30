<template>
  <div class="order-confirmation">
    <h1>确认订单</h1>
    <div class="info">
      <div class="selectAddress">选择收货地址</div>
      <div class="address">华中科技大学</div>
      <div class="contact">张三 123456789</div>
      <div class="moreAddress" @click="toggleAddressDropdown">{{ moreAddressesVisible ? '收起' : '更多' }}</div>
    </div>

    <!-- 更多地址下拉框 -->
    <div v-if="moreAddressesVisible" class="more-addresses">
      <select v-model="selectedAddress">
        <option v-for="(address, index) in addresses" :key="index" :value="address">{{ address }}</option>
      </select>
    </div>

    <!-- 添加新地址表单 -->
    <div v-if="addingNewAddress" class="add-new-address">
      <input type="text" v-model="newAddress" placeholder="请输入新地址">
      <button @click="addNewAddress">添加</button>
      <button @click="cancelAddAddress">取消</button>
    </div>

    <!-- 主要内容区域 -->
    <div class="main-content">
      <!-- 配送时间选择器 -->
      <div class="delivery-time">
        <label>选择配送时间：</label>
        <ul>
          <li v-for="(option, index) in deliveryOptions" :key="index" @click="selectDeliveryTime(option)">
            {{ option.label }}
          </li>
        </ul>
        <div v-if="selectedDeliveryTime" class="selected-time">
          已选配送时间：{{ selectedDeliveryTime }}
        </div>
      </div>

      <!-- 订单信息 -->
      <div class="order-item">
        <div class="store-info">
          氢气层(华科东校区店) - 商家自配送
        </div>
        <div class="item">
          <div class="item-info">
            <span class="discount">折</span> 葡国奶油焗饭+原味鸡块+雪碧
          </div>
          <div class="price">¥29.9</div>
        </div>
        <div class="extra-fees">
          <div>打包费 ¥2.5</div>
          <div>配送费 ¥0 (免配送费)</div>
        </div>
        <div class="discount-info">
          <div class="discount">
            已优惠 ¥28
          </div>
          <div class="total">
            小计 ¥32.4
          </div>
          <div class="coupon">
            饿了么红包 (未选红包, 最高6元可用)
          </div>
        </div>
      </div>
    </div>

    <!-- 支付方式 -->
    <div class="payment-method">
      <div class="payment-option">
        <img src="//alipay-logo.png" alt="支付宝Logo" class="payment-logo">
        <label for="payment">支付方式：</label>
        <select id="payment">
          <option value="alipay" selected>支付宝</option>
          <option value="wechatPay">微信支付</option>
        </select>
      </div>
      <div class="payment-option">
        <img src="//wechatPay-logo.png" alt="微信支付Logo" class="payment-logo">
      </div>
    </div>

    <!-- 提交按钮 -->
    <div class="submit-button">
      <button @click="submitOrder">提交订单</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderConfirmation',
  data() {
    return {
      selectedDeliveryTime: '', // 初始化选中的配送时间
      deliveryOptions: [], // 存储配送时间选项的数组
      moreAddressesVisible: false, // 控制更多地址下拉框的显示状态
      addingNewAddress: false, // 控制添加新地址表单的显示状态
      addresses: ['地址1', '地址2', '地址3'], // 示例地址列表
      selectedAddress: '', // 用于存储选中的地址
      newAddress: '' // 用于存储用户输入的新地址
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
        { label: `立即送出（${currentTime}）`, value: 'now' }
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
    selectDeliveryTime(option) {
      this.selectedDeliveryTime = option.value;
    },
    submitOrder() {
      alert('订单已提交');
      // 在此处添加提交订单的逻辑
    },
    toggleAddressDropdown() {
      this.moreAddressesVisible = !this.moreAddressesVisible;
    },
    addNewAddress() {
      if (this.newAddress.trim() !== '') {
        this.addresses.push(this.newAddress);
        this.newAddress = '';
        this.addingNewAddress = false;
      }
    },
    cancelAddAddress() {
      this.newAddress = '';
      this.addingNewAddress = false;
    }
  }
};
</script>

<style scoped>
.order-confirmation {
  padding: 16px;
  background-color: #f0f0f0;
  text-align: center;
}

h1 {
  margin-top: 0;
}

.selectAddress {
  font-size: 18px; /* 调整字号大小 */
}

.info {
  background-color: white;
  padding: 16px;
  margin-bottom: 16px;
  border-radius: 8px;
}

.address,
.contact {
  margin-bottom: 8px;
}

.moreAddress {
  cursor: pointer;
  color: blue;
}

.main-content {
  display: flex;
  justify-content: space-between;
  margin-bottom: 16px;
}

.delivery-time {
  flex: 1;
  background-color: white;
  padding: 16px;
  border-radius: 8px;
}

.delivery-time label {
  margin-right: 8px;
}

.delivery-time ul {
  list-style-type: none;
  padding: 0;
}

.delivery-time li {
  cursor: pointer;
  padding: 8px 16px;
  margin-bottom: 8px;
  background-color: white;
  border-radius: 4px;
  border: 1px solid #ccc;
}

.delivery-time li:hover {
  background-color: #f0f0f0;
}

.selected-time {
  margin-top: 8px;
  font-weight: bold;
}

.order-item {
  flex: 1;
  background-color: white;
  padding: 16px;
  border-radius: 8px;
}

.store-info {
  font-weight: bold;
  margin-bottom: 8px;
}

.item {
  display: flex;
  justify-content: space-between;
}

.extra-fees {
  margin-top: 8px;
}

.discount-info {
  background-color: white;
  padding: 16px;
  border-radius: 8px;
}

.payment-method {
  margin-top: 16px; /* 调整顶部间距 */
  display: flex;
  align-items: center; /* 垂直居中 */
  justify-content: center; /* 水平居中 */
  background-color: white;
}

.payment-option {
  display: flex;
  align-items: center;
  margin-right: 20px; /* 调整支付选项之间的间距 */
}

.payment-option img.payment-logo {
  width: 40px; /* 调整logo的宽度 */
  height: auto; /* 保持宽高比 */
  margin-right: 8px; /* 调整logo与文字之间的间距 */
}

.payment-method label {
  margin-right: 8px; /* 调整标签和下拉框之间的间距 */
}

.payment-method select {
  padding: 8px; /* 调整下拉框内部填充 */
}

.more-addresses {
  margin-top: 16px;
}

.more-addresses input[type="text"] {
  padding: 8px;
  margin-right: 8px;
}

.more-addresses button {
  padding: 8px 16px;
  margin-right: 8px;
  cursor: pointer;
}

</style>
