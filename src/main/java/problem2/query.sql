SELECT td.user_id, u.username, td.training_id, td.training_date, count(td.training_id) from training_details td, users u
where  td.user_id = u.user_id
GROUP BY td.user_id, u.username, td.training_id, td.training_date
ORDER BY td.training_date DESC;