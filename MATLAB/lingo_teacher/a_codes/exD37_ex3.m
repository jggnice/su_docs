% ��ѧ��ѧʵ��|2 p.311|322 ʵ��12|13 ��3, ��������ʩ��������� 

clear

[A,B] = xlsread('dxsxsy2.xls', '13_e3');

y = A(:, 2); 	%��2�������ǲ���y
x = A(:, 3); 	%��3��������ʩ����x
plot(x,y,'*'), grid
set(gcf,'color','n')	% 'n'����ɫ��'k'��ɫ��'w'��ɫ��gca :�м�

X = [ones(14,1), x, x.*x];
[b, bint, r, rint, stat ] = regress(y, X) ;
b, bint, stat, s_2 = r'*r/(14-3)	
%rcoplot(r, rint)
rcoplotw(r, rint)	%  ��rcoplotw����������������������ɫ���ɫ

p = polyfit(x,y,2)	% p��������x^2, x, 1��ϵ��

polytool(x,y,2)