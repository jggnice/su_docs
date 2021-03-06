% 大学数学实验2 p.69-70,80-81  例2  弱 肉 强 食 
% 大学数学实验  p.69-70,79-80  例2  弱 肉 强 食   
% 种群甲靠丰富的自然资源生存  
% 种群乙靠捕食种群甲为生  
% 甲独立生存的增长率 r  
% 乙使甲的增长率减小,  减小量与 y 成正比 a
% 乙独立生存的死亡率 d  
% 甲使乙的死亡率减小,  减小量与 x 成正比 b

ts=0:0.1:15;

x0 = [25, 2];    
[t,x] = ode45('ex442shier', ts, x0); 
[t,x]

figure(1)
plot(t,x),grid,
text(3,63,'\fontsize{14}x(t)'),text(5.5,17,'\fontsize{14}y(t)'),
title('数值解 x(t), y(t)的图形')

figure(2)
plot(x(:,1),x(:,2)),title('相轨线 y(x) 的图形'),grid,
xlabel('x'),ylabel('y')

xx=x(1:108,:);   %大致一个周期的解
mean(xx)	         %大致一个周期解的平均值
 