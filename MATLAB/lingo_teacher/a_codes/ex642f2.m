function y=iter01(x,r)
% 大学数学实验  p.35-38      2.4.1 例6  离散形式的阻滞增长模型(Logistic模型)  
% 大学数学实验  p.129-131  6.4           分岔与混沌现象  
% x.k ~ 某种群第 k 代的数量 :x.k+1 – x.k = r ( 1 – x.k/N ) x.k   
y=r*x*(1-x);

