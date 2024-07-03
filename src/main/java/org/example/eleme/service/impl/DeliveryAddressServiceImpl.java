package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.DeliveryAddressMapper;
import org.example.eleme.model.DeliveryAddress;
import org.example.eleme.service.DeliveryAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deliveryAddressService")
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper,DeliveryAddress>  implements DeliveryAddressService {



    public List<DeliveryAddress> getAllDeliveryAddresses() {
        return baseMapper.getAll();
    }

    public void saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        baseMapper.insertDeliveryAddress(deliveryAddress);
    }


    public void deleteDeliveryAddress(Long id) {
        baseMapper.deleteDeliveryAddress(id);
    }

//    public DeliveryAddress getDeliveryAddressById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public DeliveryAddress createDeliveryAddress(DeliveryAddress user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteDeliveryAddress(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public DeliveryAddress getDeliveryAddressByDeliveryAddressname(String username) {
//        return userRepository.findByDeliveryAddressname(username);
//    }
}
