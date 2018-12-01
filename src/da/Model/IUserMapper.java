//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易


package da.Model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserMapper {
    //    @Insert("insert into User (name, password,admin) values ('${name}', '${password}',#{admin})")
    @Insert("insert into User (name, password) values (#{name}, #{password})")
    int add(User user);

    @Delete("delete from User where id=#{id}")
    int deleteById(int id);

    @Update("update User set name='${name}', password='${password}',admin=#{admin} where id=${id}")
    int update(User user);

    @Select("select * from User where id=#{id}")
    User getById(int id);

    @Select("select * from User where name=#{name}")
    User getByName(String name);

    @Select("select * from User")
    List<User> getAll();
}
