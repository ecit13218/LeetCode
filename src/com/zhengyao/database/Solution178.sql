Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report (order by highest score):

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+

--对分数表进行排名，相同名次的排名相同，中间不可以断开
--这个地方可以介绍一下rank() over()，dense_rank()over(),row_number()over()的使用区别
--rank()over()是中间会有断层，比如两个人排第一，则下一个人排第三，dense_rank()over()则不一样，两个人排第一，下一个人不会断开，排第二,row_number()over()则是相同数据的组内自我排名，两个分数相同的排出1,2，下一条不一样的数据则还是从1开始排

select Score ,dense_rank() over(order by to_number(Score) desc) as rank from Scores;
