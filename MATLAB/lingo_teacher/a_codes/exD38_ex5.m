% 大学数学实验|2 p.316|327 实验12|13 例5, 儿童的体重与身高和年龄

clear

[A,B] = xlsread('dxsxsy2.xls', '13_e5');

y  = A(:,2); 	%第2列数据是体重y
x1 = A(:,3); 	%第3列数据是身高x1
x2 = A(:,4); 	%第3列数据是年龄x2
plot(x1,y,'*'), pause
plot(x2,y,'*'), pause


X = [ones(length(x1),1), x1, x2];
[b, bint, r, rint, stat ] = regress(y, X) ;

X1 = [x1,x2, x1.*x1, x2.*x2, x1.*x2];
stepwise(X1,y,[1, 2])

