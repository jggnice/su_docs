% ��ѧ��ѧʵ��|2 p.312|323 ʵ��12|13 ��4, ��Ʒ��������۸� 

clear

[A,B] = xlsread('dxsxsy2.xls', '13_e4');

y = A(:, 2); 	%��2����������Ʒ������y
x1 = A(:, 3); 	%��3�������Ƕ��ּ۸�x1
x2 = A(:, 4); 	%��3�������Ǳ����۸�x2
plot(x1,y,'*'), grid,pause
plot(x2,y,'*'), grid,pause


X = [ones(10,1), x1, x2];
[b, bint, r, rint, stat ] = regress(y, X) ;
b, bint, stat, s_2 = r'*r/(10-3)	
%rcoplot(r, rint)
rcoplotw(r, rint)	%  ��rcoplotw����������������������ɫ���ɫ

rstool([x1,x2],y,'purequadratic')
