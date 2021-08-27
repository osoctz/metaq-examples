package cn.metaq.auth.security.biz.impl;

import cn.metaq.auth.security.biz.RoleBiz;
import cn.metaq.auth.security.dao.RoleDao;
import cn.metaq.auth.security.dto.RoleDTO;
import cn.metaq.auth.security.entity.Role;
import cn.metaq.common.core.dto.Pagination;
import cn.metaq.data.jpa.BaseBiz;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RoleBizImpl
 *
 * @author tz
 * @date 2020/11/27 下午1:34
 * @since 1.0
 */
@Service
public class RoleBizImpl extends BaseBiz<RoleDTO, RoleDTO, Long, RoleDao> implements RoleBiz {

    @Override
    public Pagination<RoleDTO> list(RoleDTO dto, int offset, int limit) {

        Page<Role> page = null;
        Pageable pageable = PageRequest.of(offset / limit, limit);

        if (dto != null) {
            page = dao.findAll(this.map(dto), pageable);
        } else {
            page = dao.findAll(pageable);
        }

        Pagination<RoleDTO> pagination = new Pagination();

        pagination.setOffset(offset);
        pagination.setLimit(limit);
        pagination.setTotal((int) page.getTotalElements());
        pagination.setData(page.getContent().stream().map(s -> {

            RoleDTO role = new RoleDTO();
            role.setName(s.getName());
            role.setCode(s.getCode());
            return role;
        }).collect(Collectors.toList()));
        return pagination;
    }

    @Override
    public Specification map(RoleDTO dto) {

        return (Specification) (root, cq, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotEmpty(dto.getName())) {
                predicates.add(cb.equal(root.get("name"), dto.getName()));
            }

            if (StringUtils.isNotEmpty(dto.getCode())) {
                predicates.add(cb.equal(root.get("code"), dto.getCode()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
