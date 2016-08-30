% 大学数学实验|2 p.312|323 实验12|13 例4, 商品销售量与价格 

clear

[A,B] = xlsread('dxsxsy2.xls', '13_e4');

y = A(:, 2); 	%第2列数据是商品销售量y
x1 = A(:, 3); 	%第3列数据是对手价格x1
x2 = A(:, 4); 	%第3列数据是本厂价格x2
plot(x1,y,'*'), grid,pause
plot(x2,y,'*'), grid,pause


X = [ones(10,1), x1, x2];
[b, bint, r, rint, stat ] = regress(y, X) ;
b, bint, stat, s_2 = r'*r/(10-3)	
%rcoplot(r, rint)
rcoplotw(r, rint)	%  《rcoplotw》——王振羽重设了线条色与底色

rstool([x1,x2],y,'purequadratic')
