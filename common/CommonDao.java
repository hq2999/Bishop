package com.nbport.ediportal.application.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.StatelessSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commonDao")
@Transactional
public class CommonDao {
	private static final Logger logger = Logger.getLogger(CommonDao.class);

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate = null;

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate = null;

	private static JdbcTemplate staticJdbcTemplate = null;
	private static HibernateTemplate staticHibernateTemplate = null;

	@PostConstruct
	public void init() {
		staticJdbcTemplate = jdbcTemplate;
		staticHibernateTemplate = hibernateTemplate;
	}

	/**
	 * 使用原生SQL查询，返回List<Map<String, String>>结构的数据集，map's key 的格式为驼峰式
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Map<String, Object>> findBySql(String sql, Object[] params) {
		List list = staticJdbcTemplate.query(sql, params, new RowMapper<Map<String, String>>() {
			public Map<String, String> mapRow(ResultSet rs, int arg1) throws SQLException {
				ResultSetMetaData meta = rs.getMetaData();
				int c = meta.getColumnCount();
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 0; i < c; i++) {
					String columnLabel = meta.getColumnLabel(i + 1);
					map.put(toLowerCamel(columnLabel), StringUtils.trimToEmpty(rs.getString(columnLabel)));
				}
				return map;
			}
		});
		return list;
	}

	/**
	 * 使用原生SQL查询结果，在list中选两字段，一个key、一个value，组装成一个map
	 * 
	 * @param sql
	 * @param params
	 * @param keyField
	 * @param valueField
	 * @return
	 */
	public static Map<String, Object> findBySql2Map(String sql, Object[] params, String keyField, String valueField) {
		List<Map<String, Object>> list = findBySql(sql, params);
		Map<String, Object> result = new HashMap<String, Object>();

		for (Map<String, Object> item : list) {
			result.put(item.get(keyField).toString(), item.get(valueField));
		}

		return result;
	}

	// 带分页功能的原生sql查询
	public static List<Map<String, Object>> findBySql(String sql, Object[] param, int start, int limits) {
		List<Map<String, Object>> tlist = staticJdbcTemplate.queryForList("select * from (" + sql + ") where rownum<2", param);
		List<String> cols = new ArrayList<String>();

		for (Map<String, Object> map : tlist) {
			for (String key : map.keySet()) {
				cols.add(toLowerCamel(key));
			}
		}

		List<Map<String, Object>> rlist = new ArrayList<Map<String, Object>>();

		StatelessSession session = null;

		try {
			session = staticHibernateTemplate.getSessionFactory().openStatelessSession();
			Query q = session.createSQLQuery(sql);

			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					q.setParameter(i, param[i]);
				}
			}
			q.setFirstResult(start);
			q.setMaxResults(limits);

			List<Object[]> list = q.list();

			if (cols.size() == 1) {
				for (Object objs : list) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put(cols.get(0), objs == null ? "" : StringUtils.trimToEmpty(objs.toString()));
					rlist.add(map);
				}
			} else {
				for (Object[] objs : list) {
					Map<String, Object> map = new HashMap<String, Object>();
					for (int i = 0; i < cols.size(); i++) {
						map.put(cols.get(i), objs[i] == null ? "" : StringUtils.trimToEmpty(objs[i].toString()));
					}
					rlist.add(map);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return rlist;
	}

	public int getRecordCount(String sql, Object[] param) {
		sql = sql.replaceFirst("(?<=select) .+? (?=from)", " count(*) c ");
		List<Map<String, Object>> tlist = staticJdbcTemplate.queryForList(sql, param);
		return Integer.parseInt(tlist.get(0).get("c").toString());
	}

	public int getRecordCount(String sql) {
		sql = sql.replaceFirst("(?<=select) .+? (?=from)", " count(*) c ");
		List<Map<String, Object>> tlist = staticJdbcTemplate.queryForList(sql);
		return Integer.parseInt(tlist.get(0).get("c").toString());
	}

	public static String toLowerCamel(String str) {
		if (StringUtils.isEmpty(str)) {
			return "";
		} else {
			str = str.toLowerCase();
		}

		Pattern p = Pattern.compile("_+([a-z])");
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();

		while (m.find()) {
			m.appendReplacement(sb, m.group(1).toUpperCase());
		}

		m.appendTail(sb);
		return sb.toString();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
