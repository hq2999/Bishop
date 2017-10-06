select
e.COMMENTS,
b.TABLE_NAME,
b.COLUMN_ID,
b.COLUMN_NAME,
b.DATA_TYPE,
b.data_length,
b.nullable,
d.CONSTRAINT_TYPE,
a.COMMENTS
from USER_COL_COMMENTS a
left join cols b on a.TABLE_NAME=b.TABLE_NAME and a.COLUMN_NAME=b.COLUMN_NAME
left join user_cons_columns c on c.TABLE_NAME=a.TABLE_NAME and c.COLUMN_NAME=a.COLUMN_NAME and c.POSITION is not null
left join user_constraints d on d.TABLE_NAME=c.TABLE_NAME and d.CONSTRAINT_NAME=c.CONSTRAINT_NAME and d.CONSTRAINT_TYPE='P'
left join USER_TAB_COMMENTS e on a.TABLE_NAME=e.TABLE_NAME
order by b.table_name asc ,b.COLUMN_ID asc
