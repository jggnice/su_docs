% ��ѧ��ѧʵ��2  p.47  
% 3.2.1.3 �������ղ�ֵ����ʽ���� (Runge.m)
nn = [ 2 4 6 8 10 ]
x = -5:0.1:5;
z = zeros(1,length(x));
y = 1./(1+x.*x);		% x�ĺ���ֵһg(x)
for n = nn
    x0 = linspace(-5,5,n+1);    % n+1 ���ڵ�� x ����
    y0 = 1./(1+x0.*x0);         % n+1 ���ڵ�� yx ����
    y1 = ex324lagr(x0,y0,x);		% �� n+1 ���ڵ���� x ���Ĳ�ֵ����ֵ	
    plot(x,y1,x,z,'k',x,y,'.k','linewidth',2),pause	%�ֱ���ͼ
    yy(n/2,:) = y1;
end
plot(x,yy,x,z,'k',x,y,'.k','linewidth',2)