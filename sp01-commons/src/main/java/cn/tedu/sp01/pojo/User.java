package cn.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author XinP
 * @Date 2020/8/25 9:57
 */
@Data
@NoArgsConstructor  //无参构造
@AllArgsConstructor //全参构造
public class User {
    private Integer id;
    private String username;
    private String password;
}
