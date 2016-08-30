package not_file;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class CreateFile {
	public static int decode(String[] args) throws IOException {
		final String cipherText64 = "tuDSu7XjV2h5Pw0KoaGhoQ0KoaGhobWx0ru49rnLv82jrL34terKsb+0tb216sDvtcTUsbmktc3Nt83myta7+qOsu+HT0Mqyw7S40L71o78NCqGhoaENCqGhoaG1scTjwM/GxdfcsafUubzeuPjE48O709C5/brDyNXX07XEyrG68qO/DQqhoaGhDQqhoaGhtbHE47Gn1LnX1Ly6wvKyu8bwt7/X07XEyrG68qO/DQqhoaGhDQqhoaGhtbHE47Gn1Lmx8MjLttTE47K7ubu6w7XEyrG68g0KoaGhoQ0KoaGhocfrz8jP68/rxOPT1srHyrLDtNH519MNCqGhoaENCqGhoaHP68/r19S8utXi0rvM7La81/bBy8qyw7Sjvw0KoaGhoQ0KoaGhocrHt/HV5rXEvqHBpsHLo78NCqGhoaENCqGhoaHG5Mq1yse6/cWq19S8uqGtoa0NCqGhoaENCqGhoaHM7LXAs+rH2qOsyMu1wLPqs8+jrMnMtcCz6tDFo6zStbXAs+q+q6OhDQqhoaGhDQqhoaGht8XPwsrWu/qjrLrDusPRp8+woaK6w7rDuaTX96OstNPO0tf2xvCjoQ0KoaGhoQ0KoaGhodK7uPbBpsfzyc+9+LXEyMujrLrctuDX9sjL1/bKwrXEserXvKOssrvQ6NKqsfDIy7a9tNmjoQ0KoaGhoQ0KoaGhobK70qrU2sTDuaTXyrXEtdi3vc3myta7+qGjDQqhoaGhDQq7u867y7y/vA0KoaGhoQ0KoaGhobzZyOfJ6M/rxOPP1tTaysfAz7Dlo6y74dS40uLGuNPDz9bU2rXE19S8usLwo78NCqGhoaENCqGhoaHI57n7t8ezo8DW0uKjrMTHvs28zND41eLR+df2z8LIpaO7DQqhoaGhDQqhoaGhyOe5+8/gt7TE47K71LjS4sa408PX1Ly6o6zEx77N06a4w8ilt7TLvMTj19S8urWxz8K1xNDQzqqjoQ0KoaGhoQ0KoaGhobK7xcLGuNPDw7vT0Lmk1/e+rdHptcTIyyy1q9fu1tW3xcb6tcTKx8O709C5pNf3zKy2yLXEyMujrM7ewtvE48rHy62joQ0KoaGhoQ0KoaGhobHPvrmjrLmk1/fW0M21vOnLo7uso7vX9srCx+nS9bfu0fTOpaO7tbHD5rmk1/e7/byro6yxs7rzz/u8q7WhuaSju7+0wM+w5bjJu+6jrMrTytXI69f2ysKju8rCysK9773vvMa9z9Pa0dvHsMD70ua1w8qno6zV4tCpysLH6dTZu+HOsdewtcTIy6OstrzKx8atsru5/dfUvLq1xKOhDQqhoaGhDQqhoaGh1+6686OswazE49fUvLq2vLK71LjS4rnN07bX1Ly6o6zE49T1w7TIpcjDxOO1xMDPsOXW2NPDxOOjvw0KoaGhoQ0KoaGhocTcsaPXoc/W1Nq4+MTjtcTQvcuuvs2yu7Ttwcuhqw0KoaGhoQ0KoaGhocjnufvE47vsyNXX06OsttSyu8bwo6zKtbzKyc/E48rHu+zX1Ly6o6wNCqGhoaENCqGhoaHI57n7xOPU2rmry7677MjV19OjrMTjxNy62sDPsOW24MnZx66jvw0KoaGhoQ0KoaGhob/JysfE46OsyOe5+9TauavLvry4xOqyu7rDusO5pNf3o6y7xLfPwcu8uMTqo6y8uMTquvPE49T1w7Sw7MTYo78NCqGhoaENCqGhoaHE4771tcPE49PQvrrV+cGmwvCjv8Tqx+HKsbrys9S/4LK7y+PKssO0o6zAz8HLu7nSqrPUv+CjrLLFysfX7r/Jsa+1xKOhDQqhoaGhDQqhoaGhoaqhqtbCy/nT0MWswaa1xMjLo6zX1Mqho6E=";
		Base64 base64 = new Base64();
		byte[] binary1 = new byte[cipherText64.length()/4*3];
		binary1 = base64.decode(cipherText64);
		
		/**
		 * Read TXT
		 */
		java.io.FileInputStream file_txt = new java.io.FileInputStream(args[0]);
		/**
		 * Write binary
		 */
		java.io.FileOutputStream file1 = new java.io.FileOutputStream(args[1]);
		file1.write(binary1);
		file_txt.close();
		file1.close();
		return 0;
	}
	public static int decodetofile(String cipherText64,String filename) throws IOException
	{
		java.io.FileOutputStream file1 = new java.io.FileOutputStream(filename);
		Base64 base64 = new Base64();
		byte[] binary1 = new byte[cipherText64.length()/4*3];
		binary1 = base64.decode(cipherText64);
		file1.write(binary1);
		file1.close();
		return 0;
	}
	public static void main(String[] arg) throws IOException, ClassNotFoundException 
	{
		
		String[] file = new String[2];
		file[0] = "lswqq";
		TestRSAnoPadding.S2S(file);
		System.out.println(file[1]);
		String[] file1 = new String[2];
		file1[0] = file[1];
		TestRSAnoPadding.S2S2(file1);
		System.out.println(file1[1]);
	}
}
