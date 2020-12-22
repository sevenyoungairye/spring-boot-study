package cn.bitqian.service.impl;

import cn.bitqian.entity.Account;
import cn.bitqian.mapper.AccountMapper;
import cn.bitqian.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author echo lovely
 * @since 2020-11-17
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
