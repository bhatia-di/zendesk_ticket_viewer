import React, { useState } from "react";
import ReactLoading from 'react-loading';
import * as APIURLS from "../../constants/APIConstants";
import Accordion from 'react-bootstrap/Accordion';
// import "../../styles/index.css";
import { faClipboardList, faChevronCircleLeft, faChevronCircleRight } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default function TicketViewerPage() {
  const [tickets, setTickets] = useState([{subject: "ABC"}]);
  const [page, setPage] = useState("null");
  const [pageLink, setPageLink] = useState("null");
  const [pageSize, setPageSize] = useState("null");


  React.useEffect(() => {

  let params = {"page": page, "pageSize": pageSize, "pageLink": pageLink};
  console.log(params);

//   fetch(APIURLS.getTicketsURL + "/" + new URLSearchParams(params).toString())
//   .then(response => response.json())
//                 .then(result => {
//                     setTickets(result.tickets);
//                     }).catch((error) => {
//                     console.error("Fetch API Call failed with an error" + error);
//                     });


  }, []);




  if (tickets) {
    return (
    <div className={"container-fluid"}>
    <div className={"card-layout"}>
       <h3 className={"color-aqua"}>
        <FontAwesomeIcon icon={faClipboardList} color="#1f939c" />
        <span className={"ml-2"}>Let's view all tickets!</span>
       </h3>
    </div>

    <div className={"row"}>
        <div className={"col-10"}>
        </div>
        <div className={"col-2"}>

            <a><FontAwesomeIcon icon={faChevronCircleLeft} color="#1f939c" size="md" /></a>
            <a className={"ml-2"} ><FontAwesomeIcon icon={faChevronCircleRight} color="#1f939c" size="md" /></a>
        </div>

    </div>
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
