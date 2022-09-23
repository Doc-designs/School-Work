/*
 * 
 * A letter is a document. A letter has a sender, receiver, receiver address.
 */
//-----------Start below here. To do: approximate lines of code = 1
// make class Letter a subclass of Document
class Letter extends Document
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
	private String sender, receiver;
	private String receiverAddress;
	
	public Letter(String id, String receiver, String address, String sender)
	{
		super(id);
		this.receiver = receiver;
		this.receiverAddress = address;
		this.sender = sender;
	}
	
	// Set the body of the letter. Overrides the setBody() method in Document 
	public void setBody(String letterBody)
	{
		//-----------Start below here. To do: approximate lines of code = 2
		// Set the string body variable, inherited from Document. Create a string conatining
		// the receiver address followed by "\n\nDear " followed by the receiver followed by
		// "\n\n" followed by the given letterBody string followed by "\n\nSincerely,\n" followed by
		// sender. Then use the setBody() method in the superclass 
		String receiver = getReceiverAddress() + "\n\nDear" + getReceiver() + "\n\n" + letterBody + "\n\nSincerely, \n" + getSender();
		super.setBody(receiver);
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	public String getSender()
	{
		return sender;
	}

	public void setSender(String sender)
	{
		this.sender = sender;
	}

	public String getReceiver()
	{
		return receiver;
	}

	public void setReceiver(String receiver)
	{
		this.receiver = receiver;
	}

	public String getReceiverAddress()
	{
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress)
	{
		this.receiverAddress = receiverAddress;
	}
}
