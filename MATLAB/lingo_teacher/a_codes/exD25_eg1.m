% ��ѧ��ѧʵ��2 p.302,306,312-313 ʵ��12 ʵ��1,��1 Ѫѹ������
% ��ѧ��ѧʵ��  p.289,293,299-301 ʵ��12 ʵ��1,��1 Ѫѹ������

clear

[A,B] = xlsread('dxsxsy2.xls', '13_1');
%A1=textread('JZ301.txt');
dlmwrite('test1.dat',A,'\t')
dlmwrite('test2.dat',A)
csvwrite('test3.dat',A)
Atext=textread('test1.dat');
Adlm=dlmread('test2.dat');
Acsv=csvread('test3.dat');
%xlswrite('test4.xls', A, '12_01') 	%6.5�汾�²�����
%xlswrite('test4.xls', A, '12_01BF') 	%6.5�汾�²�����

y = A(:, 2); 	%��2��������Ѫѹy
x = A(:, 3); 	%��3������������x
plot(x,y,'*'), grid
%set(gcf,'color','n')	% 'n'����ɫ��'k'��ɫ��'w'��ɫ��gca :�м�
pause

X = [ones(30,1), x];
[b, bint, r, rint, stat ] = regress(y, X) ;
b, bint, stat, s_2 = r'*r/(30-2)	
rcoplot(r, rint), pause
%rcoplotw(r, rint)	%  ��rcoplotw����������������������ɫ���ɫ

X1 = X; X1(2,:)=[];  % �޳���2��
y1 = y; y1(2)=[];
[b1, bint1, r1, rint1, stat1 ] = regress(y1, X1) ;
b1, bint1, stat1, s1_2 = r1'*r1/(29-2)
rcoplot(r1, rint1)
%rcoplotw(r1, rint1)	
