% 大学数学实验|2 p.262|276, p.279|292  
% 实验11|12  实例2   吸烟对血压的影响 
%	吸烟组均值  吸烟组标准差  不吸烟组均值  不吸烟组标准差
%24hSBP(mmHg)	119.35	10.77	114.79	8.28
%24hDBP(mmHg)	76.83	8.45	72.87	6.20
%dSBP(mmHg)	122.7	11.36	117.6	8.71
%dDBP(mmHg)	79.52	8.75	75.44	6.8
%nSBP(mmHg)	109.95	10.78	107.1	10.11
%nDBP(mmHg)	69.35	8.60	65.84	7.03
% [h,sig]=pttest2(xbar,ybar,s1,s2,m,n,alpha,tail)
A = [	119.35	10.77	114.79	8.28 ;
	76.83	8.45	72.87	6.20 ;
	122.7	11.36	117.6	8.71 ;
	79.52	8.75	75.44	6.8 ;
	109.95	10.78	107.1	10.11 ;
	69.35	8.60	65.84	7.03];
xbar = A(:,1);  sx = A(:,2);
ybar = A(:,3);  sy = A(:,4);
for i = 1:6
    [h(i), sig(i)] = pttest2(xbar(i), ybar(i) ,sx(i), sy(i), 66, 62, 0.05,0);
end
h=h',sig=sig'