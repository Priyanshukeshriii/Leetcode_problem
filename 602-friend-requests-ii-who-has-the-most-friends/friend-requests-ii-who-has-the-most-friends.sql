# Write your MySQL query statement below
select id , count(id) as num
from (
    select requester_id id from  RequestAccepted
    UNION all
    select accepter_id id from  RequestAccepted
) s
group by id
order by num desc
limit 1 ;