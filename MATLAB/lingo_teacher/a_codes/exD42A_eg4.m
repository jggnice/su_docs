% ��ѧ��ѧʵ��2p.304-305,330-331  ʵ��13 ʵ��4 ø�ٷ�Ӧ
% ��ѧ��ѧʵ�� p.292-293,320-321  ʵ��12 ʵ��4 ø�ٷ�Ӧ

[A,B] = xlsread('dxsxsy2.xls', '13_4');

x1=A(1:11,1); y1=A(1:11,2);	% x1, y1��δ�����������(n=11)��
x2=A(:,1);      y2=A(:,3);	% x2, y2�Ǵ��������(n=12)

plot(x1,y1,'o',x2,y2,'+'),grid,pause 		% ��p.293|305ͼ2�е�ɢ��ͼ

x=x1;
y=y1;
u=1./x;
v=1./y;
uu=[ones(11,1),u];
[b,bint,r,rint,stats]=regress(v,uu,0.05);
b,bint					% ��p.293|305���

vv=uu*b;
beta1=1/b(1,1);	
beta2=b(2,1)/b(1,1);

xx=[0.01:0.01:1.15]';	
plot(u,v,'o',u,vv),grid,pause			% ��p.293|305ͼ2
plot(x,y,'o',xx,beta1*xx./(beta2+xx)),grid,pause	% ��p.293|305ͼ3

beta0=[beta1,beta2];				%ȡ���Ի�ģ�͵Ľ����Ϊbeta�ĳ�ֵ
[beta,R,J]=nlinfit(x,y,'exD42fA',beta0);	%�����Իع�ϵ��beta�Ĺ���
betaci=nlparci(beta,R,J);			%�ع�ϵ��beta����������
beta,betaci					%���beta�Ĺ��Ƽ���������
xx=0:0.1:1.2;
yy=beta(1)*xx./(beta(2)+xx);			%��beta�Ĺ���ֵ����y��Ԥ��ֵ
%yy1=ex1204fA(beta,xx);
%[yy',yy1']					%yy��yy1��ͬ
plot(x,y,'+',xx,yy)				% ��p.320|330ͼ25

nlintool(x,y,'exD42fA',beta)			% ��p.320|330ͼ26