package cn.net.liaowei.sc.order.repository;

import cn.net.liaowei.sc.order.domain.dos.OrderMasterDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiaoWei
 */
public interface OrderMasterRepository extends JpaRepository<OrderMasterDO, Integer> {

}
