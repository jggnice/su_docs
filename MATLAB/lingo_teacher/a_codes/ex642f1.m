function chaos(iter_fun,x0,r,n) % 该函数没有返回值；iter_fun是迭代函数（句柄）；x0是迭代初值；

% 大学数学实验  p.35-38      2.4.1 例6  离散形式的阻滞增长模型(Logistic模型)  
% 大学数学实验  p.129-131  6.4           分岔与混沌现象  
% x.k ~ 某种群第 k 代的数量 :x.k+1 – x.k = r ( 1 – x.k/N ) x.k   

kr = 0;
for rr = r(1):r(3):r(2)
   % 输入中[r(1),r(2)]是参数变化的范围，r(3) 是步长
   kr = kr+1;
   y(kr,1) = feval(iter_fun,x0,rr);
   for i=2:n(2)
      %输入中n(2)是迭代序列的长度，但画图时前n(1)个迭代值被舍弃
     y(kr,i)=feval(iter_fun,y(kr,i-1),rr);
   end
end
plot([r(1):r(3):r(2)],y(:,n(1)+1:n(2)),'k.');


