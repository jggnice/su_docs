% ��ѧ��ѧʵ��|2 p.316|327 ʵ��12|13 ��5, ��ͯ����������ߺ�����

clear

[A,B] = xlsread('dxsxsy2.xls', '13_e5');

y  = A(:,2); 	%��2������������y
x1 = A(:,3); 	%��3�����������x1
x2 = A(:,4); 	%��3������������x2
plot(x1,y,'*'), pause
plot(x2,y,'*'), pause


X = [ones(length(x1),1), x1, x2];
[b, bint, r, rint, stat ] = regress(y, X) ;

X1 = [x1,x2, x1.*x1, x2.*x2, x1.*x2];
stepwise(X1,y,[1, 2])

