private static int Port = 23;
	public static SocketAddress IP;
	
	  public static void main(String[] args)
	  {
		
		System.out.println("Testing");
		try
		{
		  ServerSocket Socket = new ServerSocket(Port);
		  System.out.println("Connecting Client..");
		  boolean isConnecting = false;
		  while(!isConnecting)
		  {
			  Socket clientSocket;
		  clientSocket  = Socket.accept();
		  PrintWriter WriteStream =  new PrintWriter(clientSocket.getOutputStream());
		WriteStream.println("Welcome client");
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String  S = streamReader.readLine();
		System.out.println(S);
		streamReader.close();
		WriteStream.close();
		Socket.close();
		clientSocket.close();
		  }
		}
		catch(Exception e)
		{
		System.out.println(e.toString());	
		}
		 
		}
		  

			
			}