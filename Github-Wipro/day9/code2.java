select id, product_name,category,price,quantity,offers,description
from product 
where category in ('furniture','laptop','mobile') and price < 50000
