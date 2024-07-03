package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.DeliveryAddress;

import java.util.List;


public interface DeliveryAddressService extends IService<DeliveryAddress> {


    public List<DeliveryAddress> getAllDeliveryAddresses() ;
    void saveDeliveryAddress(DeliveryAddress deliveryAddress);

    void deleteDeliveryAddress(Long id);

//    public DeliveryAddress getDeliveryAddressById(Long id);
//
//    public DeliveryAddress createDeliveryAddress(DeliveryAddress user);
//
//    public void deleteDeliveryAddress(Long id);
//
//    public DeliveryAddress getDeliveryAddressByDeliveryAddressname(String username);
}
