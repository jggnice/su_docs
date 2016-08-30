% 大学数学实验|2 p.293|306  实验12|13 例1, 用实例12|13.1 血压与年龄数据
% 用MATLAB命令ployfit 求回归方程

clear

[A,B] = xlsread('dxsxsy2.xls', '13_1');
y = A(:, 2); 	%第2列数据是血压y
x = A(:, 3); 	%第3列数据是年龄x
plot(x,y,'*'), grid

p = polyfit(x,y,1)	% x的多项式系数的估计是高阶到低阶的！

