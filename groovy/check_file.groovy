
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		if(args.length>0) {
		
			if("-h".equals(args[0]) || "--help".equals(args[0])){
				System.out.println("--url -u");
				System.out.println("--file -f");
				return;
			}
			
			if("-u".equals(args[0]) || "--url".equals(args[0])) {
				String r = "";
				try {
					String url_str = "";
					if(args.length==1) {
						url_str = "https://raw.githubusercontent.com/ImLaoD/sub/master/ssrshare.com";
					} else {
						url_str = args[1];
					}
					
					URL url = new URL(url_str);
					URLConnection conn = url.openConnection();

					InputStream is = conn.getInputStream();
					r = IOUtils.toString(is, "utf-8");
				} catch (Exception e) {}
				
//				String r = "c3NyOi8vTVRNNUxqRTJNaTR4TVRNdU1qUTVPakkxTmpJMU9tOXlhV2RwYmpwaFpYTXRNalUyTFdObVlqcHdiR0ZwYmpwV1JHeHRUbXRvVDJOdVJrSk5WR1JFTHo5eVpXMWhjbXR6UFZVeFRsTldSVGxRVkVaZmJXdzJXRzF1UzNkMFZrYzVjbVZYT0hSTmFsVXlUV3BWTmsxRVFTWm5jbTkxY0QxV01XUllUR3hPVkZWc1VsQlVNSGQxVVRBNVRnCnNzcjovL01UTTVMakUyTWk0eE1UTXVNalE1T2pJMU5qSTVPbTl5YVdkcGJqcGhaWE10TWpVMkxXTm1ZanB3YkdGcGJqcFdSR3h0VG10b1QyTnVSa0pOVkdSRUx6OXlaVzFoY210elBWVXhUbE5XUlRsUVZFWmZiV3cyV0cxdVMzZDBWa2M1Y21WWE9IUk5hbFV5VFdwck5rMUVSU1puY205MWNEMVdNV1JZVEd4T1ZGVnNVbEJVTUhkMVVUQTVUZwpzc3I6Ly9NVGN5TGpFd05TNHlNekF1TmpFNk5ESTJNVFE2YjNKcFoybHVPbUZsY3kweU5UWXRZMlppT25Cc1lXbHVPbUZ1VGtWalJ6VnZWVWhLYjJOVlJUQXZQM0psYldGeWEzTTlWVEZPVTFaRk9WQlVSbDl0YkRaWWJXNUxkM1JXUnpseVpWYzRkRTVFU1RKTlZGRTJUVVJKSm1keWIzVndQVll4WkZoTWJFNVVWV3hTVUZRd2QzVlJNRGxPCnNzcjovL05USXVOamd1TVRjeExqRXhNRG8wT0RjME5qcHZjbWxuYVc0NllXVnpMVEkxTmkxalptSTZjR3hoYVc0NlZWZDBTVk5YV20xUmEzQjZZMnh3VXk4X2NtVnRZWEpyY3oxVk1VNVRWa1U1VUZSR1gyMXNObGh0Ymt0M2RGWkhPWEpsVnpoMFRrUm5NMDVFV1RaTlJFMG1aM0p2ZFhBOVZqRmtXRXhzVGxSVmJGSlFWREIzZFZFd09VNApzc3I6Ly9ORFV1TnpjdU1qUXdMakU0TlRveU5EQTFPbTl5YVdkcGJqcGhaWE10TWpVMkxXTm1ZanB3YkdGcGJqcGpNMDU1V201S2JGcFROVEJoZHk4X2NtVnRZWEpyY3oxVk1VNVRWa1U1VUZSR1gyMXNja1JzYVhGRWJHNWhSWFJNVkVrd1RVUlZOazFFVVNabmNtOTFjRDFXTVdSWVRHeE9WRlZzVWxCVU1IZDFVVEE1VGcKc3NyOi8vTkRVdU56Y3VNalF3TGpFNE5UbzBNRFUyT205eWFXZHBianBoWlhNdE1qVTJMV05tWWpwd2JHRnBianBqTTA1NVdtNUtiRnBUTlRCaGR5OF9jbVZ0WVhKcmN6MVZNVTVUVmtVNVVGUkdYMjFzY2tSc2FYRkViRzVoUlhSTVZGRjNUbFJaTmsxRVZTWm5jbTkxY0QxV01XUllUR3hPVkZWc1VsQlVNSGQxVVRBNVRnCnNzcjovL01UUTVMakk0TGpJd0xqRTRNam94TVRBNU9UcHZjbWxuYVc0NllXVnpMVEkxTmkxalptSTZjR3hoYVc0NlRrWm9WMXBXUVhndlAzSmxiV0Z5YTNNOVZURk9VMVpGT1ZCVVJsOXRiRFpZYlc1TGQzUldSemx5WlZjNGRFMVVSWGRQVkdzMlRVUlpKbWR5YjNWd1BWWXhaRmhNYkU1VVZXeFNVRlF3ZDNWUk1EbE8Kc3NyOi8vTVRrNExqRXpMak16TGpFM05Ub3hNVEE1T1RwdmNtbG5hVzQ2WVdWekxUSTFOaTFqWm1JNmNHeGhhVzQ2VGtab1YxcFdRWGd2UDNKbGJXRnlhM005VlRGT1UxWkZPVkJVUmw5dGJEWlliVzVMZDNSV1J6bHlaVmM0ZEUxVVJYZFBWR3MyVFVSakptZHliM1Z3UFZZeFpGaE1iRTVVVld4U1VGUXdkM1ZSTURsTwpzc3I6Ly9NVGcxTGpNNExqRTFMakV4TURveE1UQTVPVHB2Y21sbmFXNDZZV1Z6TFRJMU5pMWpabUk2Y0d4aGFXNDZUa1pvVjFwV1FYZ3ZQM0psYldGeWEzTTlWVEZPVTFaRk9WQlVSbDl2YW1KbWJHaGlRWFJVYlRsNVpFZG5aMU5IT1hOaVIwWjFXa013ZUUxVVFUVlBWRzkzVDBFbVozSnZkWEE5VmpGa1dFeHNUbFJWYkZKUVZEQjNkVkV3T1U0CnNzcjovL05EWXVNVGd5TGpFeE1DNHhNVFk2TVRFeE1EQTZiM0pwWjJsdU9tRmxjeTB5TlRZdFkyWmlPbkJzWVdsdU9rNUdhRmRhVmtGNEx6OXlaVzFoY210elBWVXhUbE5XUlRsUVZFWmZiMnBpWm14b1lrRjBWbGhTZVZwWFRtOWtRekI0VFZSRmQwMUViM2RQVVNabmNtOTFjRDFXTVdSWVRHeE9WRlZzVWxCVU1IZDFVVEE1VGcKc3NyOi8vTkRZdU1UZ3lMakV4TUM0eU1qTTZNVEV3T1RrNmIzSnBaMmx1T21GbGN5MHlOVFl0WTJaaU9uQnNZV2x1T2s1R2FGZGFWa0Y0THo5eVpXMWhjbXR6UFZVeFRsTldSVGxRVkVaZmIycGlabXhvWWtGMFZsaFNlVnBYVG05a1F6QjRUVlJCTlU5VWIzaE5RU1puY205MWNEMVdNV1JZVEd4T1ZGVnNVbEJVTUhkMVVUQTVUZwpzc3I6Ly9NVGcxTGpNNExqRTFMakV3TXpveE1URXdNRHB2Y21sbmFXNDZZV1Z6TFRJMU5pMWpabUk2Y0d4aGFXNDZUa1pvVjFwV1FYZ3ZQM0psYldGeWEzTTlWVEZPVTFaRk9WQlVSbDl2YW1KbWJHaGlRWFJVYlRsNVpFZG5aMU5IT1hOaVIwWjFXa013ZUUxVVJYZE5SRzk0VFZFbVozSnZkWEE5VmpGa1dFeHNUbFJWYkZKUVZEQjNkVkV3T1U0CnNzcjovL01UZzFMak00TGpFMUxqRXhOem94TVRFd016cHZjbWxuYVc0NllXVnpMVEkxTmkxalptSTZjR3hoYVc0NlRrWm9WMXBXUVhndlAzSmxiV0Z5YTNNOVZURk9VMVpGT1ZCVVJsOXZhbUptYkdoaVFYUlViVGw1WkVkbloxTkhPWE5pUjBaMVdrTXdlRTFVUlhkTmVtOTRUV2NtWjNKdmRYQTlWakZrV0V4c1RsUlZiRkpRVkRCM2RWRXdPVTQKc3NyOi8vTVRnMUxqTTRMakUxTGpFd016b3hNVEE1T1RwdmNtbG5hVzQ2WVdWekxUSTFOaTFqWm1JNmNHeGhhVzQ2VGtab1YxcFdRWGd2UDNKbGJXRnlhM005VlRGT1UxWkZPVkJVUmw5dmFtSm1iR2hpUVhSVWJUbDVaRWRuWjFOSE9YTmlSMFoxV2tNd2VFMVVRVFZQVkc5NFRYY21aM0p2ZFhBOVZqRmtXRXhzVGxSVmJGSlFWREIzZFZFd09VNApzc3I6Ly9NVGcxTGpNNExqRTFMakV4TURveE1URXdNRHB2Y21sbmFXNDZZV1Z6TFRJMU5pMWpabUk2Y0d4aGFXNDZUa1pvVjFwV1FYZ3ZQM0psYldGeWEzTTlWVEZPVTFaRk9WQlVSbDl2YW1KbWJHaGlRWFJVYlRsNVpFZG5aMU5IT1hOaVIwWjFXa013ZUUxVVJYZE5SRzk0VGtFbVozSnZkWEE5VmpGa1dFeHNUbFJWYkZKUVZEQjNkVkV3T1U0CnNzcjovL01UQTRMakUyTUM0eE16SXVNalU2TVRFd09UazZiM0pwWjJsdU9tRmxjeTB5TlRZdFkyWmlPbkJzWVdsdU9rNUdhRmRhVmtGNEx6OXlaVzFoY210elBWVXhUbE5XUlRsUVZFWmZiV3cyV0cxdVMzZDBWa2M1Y21WWE9IUk5WRVYzVDFSck5rMVVWU1puY205MWNEMVdNV1JZVEd4T1ZGVnNVbEJVTUhkMVVUQTVUZwpzc3I6Ly9Oall1TVRjMUxqSXlNQzR5TURFNk5EUXpPbTl5YVdkcGJqcGhaWE10TWpVMkxXTm1ZanB3YkdGcGJqcFBWMUV5V1RKT2JGbFhSWHBPZWs1cFdtcEthazlIUm1wWmFrbDVXbFJaZDFscVdtaE9WR2hwV2xSWkx6OXlaVzFoY210elBWVXhUbE5XUlRsUVZFWmZiblp2TjJ4dE56QjBOVmx4WnpWWmFYQTFObUZRTldKRE9EVk1jV0UxWW1WbFRGUlJNRTE2YjNoT1p5Wm5jbTkxY0QxV01XUllUR3hPVkZWc1VsQlVNSGQxVVRBNVRnCnNzcjovL05TNHhPREF1TnpZdU1UQXhPalEwTXpwaGRYUm9YM05vWVRGZmRqUTZZV1Z6TFRJMU5pMWpabUk2YUhSMGNGOXphVzF3YkdVNlRVUkJlVTFFWXpGbGJYQjZMejl5WlcxaGNtdHpQVlV4VGxOV1JUbFFWRVpmYld3MldHMXVTM2QwVmtjNWNtVlhPSFJPUkZGNlQycEZNeVpuY205MWNEMVdNV1JZVEd4T1ZGVnNVbEJVTUhkMVVUQTVUZwpzc3I6Ly9NUzQyTlM0eE9UWXVNak0yT2pNeU16WTRPbUYxZEdoZllXVnpNVEk0WDNOb1lURTZZV1Z6TFRJMU5pMWpabUk2Y0d4aGFXNDZZakpvZW1NelNUSk9hbGt2UDNCeWIzUnZjR0Z5WVcwOVRXcFZNMDVxY0hSYWJWbzBKbkpsYldGeWEzTTlWVEZPVTFaRk9WQlVSbDl3Y0hCdWJYVkxPSFJSTWxaMVpFaEthR0pEUW1oaWJWRm5WakpXZW1SSFZubGlhVUpGWVZoT01HTnRiR3BrUXpCNlRXcE5NazlFYjNoUFFTWm5jbTkxY0QxV01XUllUR3hPVkZWc1VsQlVNSGQxVVRBNVRnCnNzcjovL01UazFMakV5TXk0eU16Y3VPVGM2TVRFeU1qcGhkWFJvWDNOb1lURmZkalE2WVdWekxUSTFOaTFqWm1JNmNHeGhhVzQ2WkROa00weHRVbWhqYmtwc1ltMTRjR1JZWkd4aFV6VnFZakl3THo5eVpXMWhjbXR6UFZVeFRsTldSVGxRVkVaZmJXeHlSR3hwY1VSc2JtRkZkRkV5Vm5Wa1NFcG9Za05DVkdGWE5XNVpXRUoyWTIxVmRFMVVSWGxOYW05NFQxRW1aM0p2ZFhBOVZqRmtXRXhzVGxSVmJGSlFWREIzZFZFd09VNApzc3I6Ly9NVGN5TGpFd05TNHlNVEV1TXpnNk16QTFPRFU2YjNKcFoybHVPbUZsY3kweU5UWXRZMlppT25Cc1lXbHVPbUpZV2pKa2EwWlVUbXBzWVZsVlZUSXZQM0psYldGeWEzTTlWVEZPVTFaRk9WQlVSbDl0YkRaWWJXNUxkM1JXUnpseVpWYzRkRTE2UVRGUFJGVTJUV3BCSm1keWIzVndQVll4WkZoTWJFNVVWV3hTVUZRd2QzVlJNRGxPCnNzcjovL01qQTVMakUwTVM0MU9DNHhOalk2T0RBNllYVjBhRjloWlhNeE1qaGZjMmhoTVRwaFpYTXRNalUyTFdObVlqcG9kSFJ3WDNOcGJYQnNaVHBOYTFaUFYyMXdkeThfY0hKdmRHOXdZWEpoYlQxTlZGRXpUbXBCTm1JeWNEQldWbFpaSm5KbGJXRnlhM005VlRGT1UxWkZPVkJVUmw5dWRtODNiRzAzTUhRMVdYRm5OVmxwY0RVMllWQTFZa000TlV4eFlUVmlaV1ZNVkdkM1QycEplQ1puY205MWNEMVdNV1JZVEd4T1ZGVnNVbEJVTUhkMVVUQTVUZwpzc3I6Ly9NakEzTGpJME5pNDVOeTR5TXpFNk5UWTNPVHBoZFhSb1gzTm9ZVEZmZGpRNllXVnpMVEkxTmkxalptSTZjR3hoYVc0NlkxZHNOR0ZYTlhKYVYzQndMejl5WlcxaGNtdHpQVlV4VGxOV1JUbFFWRVpmYm5adk4yeHROekIwTlZseFp6VlphWEExTm1GUU5XSkRPRFZNY1dFMVltVmxURlJWTWs1NmF6Wk5ha2ttWjNKdmRYQTlWakZrV0V4c1RsUlZiRkpRVkRCM2RWRXdPVTQKc3NyOi8vTkRVdU56a3VOalF1TVRBNU9qUTBNenB2Y21sbmFXNDZZV1Z6TFRJMU5pMWpabUk2Y0d4aGFXNDZUMWRSTWxreVRteFpWMFY2VG5wT2FWcHFTbXBQUjBacVdXcEplVnBVV1hkWmFscG9UbFJvYVZwVVdTOF9jbVZ0WVhKcmN6MVZNVTVUVmtVNVVGUkdYMjUyYnpkc2JUY3dkRFZaY1djMVdXbHdOVFpoVURWaVF6ZzFUSEZoTldKbFpVeFVVVEJOZW05NVRYY21aM0p2ZFhBOVZqRmtXRXhzVGxSVmJGSlFWREIzZFZFd09VNApzc3I6Ly9ORFV1TlRZdU9UTXVNalEwT2pRME16cHZjbWxuYVc0NllXVnpMVEkxTmkxalptSTZjR3hoYVc0NlQxZFJNbGt5VG14WlYwVjZUbnBPYVZwcVNtcFBSMFpxV1dwSmVWcFVXWGRaYWxwb1RsUm9hVnBVV1M4X2NtVnRZWEpyY3oxVk1VNVRWa1U1VUZSR1gyNTJiemRzYlRjd2REVlpjV2MxV1dsd05UWmhVRFZpUXpnMVRIRmhOV0psWlV4VVVUQk5lbTk1VGtFbVozSnZkWEE5VmpGa1dFeHNUbFJWYkZKUVZEQjNkVkV3T1U0CnNzcjovL09URXVNakU1TGpJek55NHhNVGs2T1RBd01UcHZjbWxuYVc0NllXVnpMVEkxTmkxalptSTZjR3hoYVc0NldqSldNR1J1UW5WTmFrRjRUMVJCTVUxRVJTOF9jbVZ0WVhKcmN6MVZNVTVUVmtVNVVGUkdYMnhxU1dwdWFWcHViR2xMYTNSUmJsWnJXVmhDYkdNelVYUlBWRUYzVFZSdmVVNVJKbWR5YjNWd1BWWXhaRmhNYkU1VVZXeFNVRlF3ZDNWUk1EbE8Kc3NyOi8vTkRZdU1qa3VNVFl5TGpRMk9qRXdNalk2YjNKcFoybHVPbkpqTkMxdFpEVTZjR3hoYVc0NlQxUkdNbU5ITkhWWk1sa3ZQM0psYldGeWEzTTlWVEZPVTFaRk9WQlVSbDlyZGpSVWJuWmFabTFzY1RoMFZGYzVlbGt5T1ROTVZFVjNUV3BaTmsxcVdTWm5jbTkxY0QxV01XUllUR3hPVkZWc1VsQlVNSGQxVVRBNVRnCnNzcjovL01UWTRMall5TGpFMk15NHhNVGM2T1Rrek9tOXlhV2RwYmpweVl6UXRiV1ExT25Cc1lXbHVPazFxUVhoUFV6UjNUWGswZDA1M0x6OXlaVzFoY210elBWVXhUbE5XUlRsUVZFWmZiblp2TjJ4dE56QjBOV0o1V0RWYVEwbzFZa000TlV4eFlUVmlaV1ZNVkdzMVRYcHZlVTUzSm1keWIzVndQVll4WkZoTWJFNVVWV3hTVUZRd2QzVlJNRGxPCnNzcjovL05qY3VNakV1T0RFdU1qUXdPamd6T0RnNmIzSnBaMmx1T21GbGN5MHlOVFl0WTJaaU9uQnNZV2x1T21OSFJucGpNMlIyWTIxUkx6OXlaVzFoY210elBWVXhUbE5XUlRsUVZFWmZiblp2TjJ4dE56QjBOVmx4WnpWWmFYQTFObUZRTldKRE9EVk1jV0UxWW1WbFRGUm5lazlFWnpaTmFtY21aM0p2ZFhBOVZqRmtXRXhzVGxSVmJGSlFWREIzZFZFd09VNApzc3I6Ly9ZMmhsYm1ka2RTMWphR2x1WVMxd2NtOTRlVEV1WkdGeWNtVnVMV3hsWlM1dVpYUTZPREE0TVRwdmNtbG5hVzQ2Y21NMExXMWtOVHB3YkdGcGJqcFBSRUUwVFZFdlAzSmxiV0Z5YTNNOVZURk9VMVpGT1ZCVVJsOXNiVFYyYkhRMU0yNXVTVWh0YVVwRWNHYzNNMngxU1Vsbk5UVlRNVFZNTFdoTVZHZDNUMFJGTmsxcWF5Wm5jbTkxY0QxV01XUllUR3hPVkZWc1VsQlVNSGQxVVRBNVRnCnNzcjovL1kyaGxibWRrZFMxamFHbHVZUzF3Y205NGVUSXVaR0Z5Y21WdUxXeGxaUzV1WlhRNk9EQTRNVHB2Y21sbmFXNDZjbU0wTFcxa05UcHdiR0ZwYmpwUFJFRTBUVkV2UDNKbGJXRnlhM005VlRGT1UxWkZPVkJVUmw5c2JUVjJiSFExTTI1dVNVaHRhVXBFY0djM00yeDFTVWxuTlRWVE1UVk1MV2hNVkdkM1QwUkZOazE2UVNabmNtOTFjRDFXTVdSWVRHeE9WRlZzVWxCVU1IZDFVVEE1VGcK";
				
				byte[] ssrItem = Base64.decodeBase64(r);
				
				String s = new String(ssrItem);
			
				String[] items = s.split("\n");
				
				list = Arrays.asList(items);
			}
			
			if("-f".equals(args[0]) || "--file".equals(args[0])) {
//				D:/workspace/ssr.txt
				try {
					list = FileUtils.readLines(new File(args[1]), "utf-8");
				} catch (Exception e) {}
			}
		}
			
			
			
		try {	
			for(int i=0;i<list.size();i++){
				byte[] item_byte = Base64.decodeBase64(list.get(i).substring(6, list.get(i).length()));
//				System.out.println(items[i].substring(6, items[i].length()));
				String item_string = new String(item_byte);
//				System.out.println(item_string);
				
				String[] p = item_string.split("\\?");
				
				String[] p0 = p[0].split("\\:");
				
				String ip = p0[0];
				String port = p0[1];
				String ori = p0[2];
				String sec = p0[3];
				String plain = p0[4];
				String other = p0[5];
				
				Map<String, String> param_map = utl2map(p[1]);
				
				String remarks = param_map.get("remarks");
				String group = param_map.get("group");

//				System.out.println(remarks);
				CheckThread ct = new CheckThread(remarks, ip, Integer.parseInt(port), i);
				
				ct.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
           // e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
               // e.printStackTrace();
            }
        }
        return true;
    }
	
	public static Map<String, String> utl2map(String param_str) {
		Map<String, String> r = new HashMap<String, String>();
		
        String[] items = param_str.split("&");
        for(int i=0;i<items.length;i++){
        	String[] p = items[i].split("\\=");
        	try {
				r.put(p[0], new String(Base64.decodeBase64(p[1]),"utf-8"));
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
        
        return r;
    }
}

public class CheckThread extends Thread{
	private String ip;
	private int port;
	private String title;
	private int ix;
	
	public CheckThread(String title, String ip, int port, int ix) {
		this.ip = ip;
		this.port = port;
		this.title = title;
		this.ix=ix;
	}
	
	@Override
	public void run() {
		long b = new Date().getTime();
		boolean r = isHostConnectable(ip, port);
		long e = new Date().getTime();
		System.out.println(title + ":" + (e-b) + ":" + r+ ":" + ix);
	}
	
	
	public boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port)); 
        } catch (IOException e) {
           // e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
               // e.printStackTrace();
            }
        }
        return true;
    }	
}
