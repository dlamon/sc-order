package cn.net.liaowei.sc.order.repository;

import cn.net.liaowei.sc.order.domain.dos.OrderDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiaoWei
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetailDO, Integer>  {

}
