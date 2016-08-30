% 大学数学实验|2 p.311|322 实验12|13 例3, 西红柿的施肥量与产量 

clear

[A,B] = xlsread('dxsxsy2.xls', '13_e3');

y = A(:, 2); 	%第2列数据是产量y
x = A(:, 3); 	%第3列数据是施肥量x
plot(x,y,'*'), grid
set(gcf,'color','n')	% 'n'无颜色，'k'黑色，'w'白色，gca :中间

X = [ones(14,1), x, x.*x];
[b, bint, r, rint, stat ] = regress(y, X) ;
b, bint, stat, s_2 = r'*r/(14-3)	
%rcoplot(r, rint)
rcoplotw(r, rint)	%  《rcoplotw》——王振羽重设了线条色与底色

p = polyfit(x,y,2)	% p中依次是x^2, x, 1的系数

polytool(x,y,2)