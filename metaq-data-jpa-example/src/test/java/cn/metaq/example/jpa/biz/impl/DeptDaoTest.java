package cn.metaq.example.jpa.biz.impl;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DeptDaoTest {

//    @Autowired
//    private DeptDao deptDao;
//
//    @Resource
//    private UserDao userDao;
//
//    @Autowired
//    private DaoTemplate daoTemplate;
//
//    @Test
//    public void testFind() throws JsonProcessingException {
//
////       Optional<Dept> dept=deptDao.findById(650400000000004000l);
//
//        Optional<Dept> d = deptDao.findOne(new Specification<Dept>() {
//            @Override
//            public Predicate toPredicate(Root<Dept> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.equal(root.get("id"), "650400000000004000");
//            }
//        });
//
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<UserGroupBy> list = userDao.findUserGroupByByDeptId();
//        //List<User> users=userDao.findAll();
////String jql="select new cn.metaq.example.jpa.model.dto.UserGroupBy(count(t.deptId),t.deptId) from cn.metaq.example.jpa.model.entity.User t group by t.deptId";
////        List<UserGroupBy> list=daoTemplate.list(UserGroupBy.class,jql);
//        Map<String, Long> kv = new HashMap<>();
//        for (UserGroupBy o : list) {
//            kv.put(o.getDeptId(), o.getNum());
//        }
//
//        if (d.isPresent()) {
//
//            Dept dd = d.get();
//            next(dd, kv);
//            System.out.println(mapper.writeValueAsString(dd));
//        }
//
//
//    }
//
//
//    public Dept next(Dept d, Map<String, Long> kv) {
//
//        if (kv.get(String.valueOf(d.getId())) != null) {
//            if (kv.get(String.valueOf(d.getId())) > 1) {
//                System.out.println("d = " + kv.get(String.valueOf(d.getId())) + ", kv = " + d.getId());
//            }
//            d.setCount(kv.get(String.valueOf(d.getId())));
//        }
//
//
//        if (d.getChildren() != null && !d.getChildren().isEmpty()) {
//
//            for (Dept dd : d.getChildren()) {
//                next(dd, kv);
//            }
//        }
//
//        return d;
//    }
}
