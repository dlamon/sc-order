package cn.net.liaowei.sc.order.repository;

import cn.net.liaowei.sc.order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiaoWei
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>  {

}
