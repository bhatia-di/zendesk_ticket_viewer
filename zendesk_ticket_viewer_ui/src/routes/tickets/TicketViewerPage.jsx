import React, { useState } from "react";
import ReactLoading from 'react-loading';
import * as APIURLS from "../../constants/APIConstants";
import Accordion from 'react-bootstrap/Accordion';


export default function TicketViewerPage() {
  const [tickets, setTickets] = useState(null);
  React.useEffect(() => {
        fetch(APIURLS.getTicketsURL).then(response => response.json())
        .then(result => {
            setTickets(result.tickets);
        });
 }, []);


  if (tickets) {
    return (
    <div className={"container-fluid"}>
      <h1><i className="fa fa-amazon mr-2"  />Let's view all tickets ...</h1>
      <Accordion>

        {
        tickets.map((ticket, index) =>

          <Accordion.Item eventKey={"accordion" + index + ""}>
              <Accordion.Header>{ticket.subject}</Accordion.Header>
              <Accordion.Body>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
                    veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
                    velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id
                    est laborum.
              </Accordion.Body>

          </Accordion.Item>




        )
        }
    </Accordion>
    </div>


    );

  } else {
   return(
       <div className={"container-fluid"}>
            <ReactLoading type={"spinningBubbles"} color={"#1f939c"} height={'20%'} width={'20%'} />
      </div>

      );

  }





}
