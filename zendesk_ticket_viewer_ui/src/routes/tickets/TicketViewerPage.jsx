import React, { useState } from "react";
import ReactLoading from 'react-loading';
import * as APIURLS from "../../constants/APIConstants";
import Accordion from 'react-bootstrap/Accordion';
import {Input} from 'reactstrap';

import "../../styles/index.css";
import { faClipboardList, faChevronCircleLeft, faChevronCircleRight } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default function TicketViewerPage() {
  const [tickets, setTickets] = useState(null);
  const [meta, setMeta] = useState(null);
  const [page, setPage] = useState(null);
  const [pageLink, setPageLink] = useState(null);
  const [pageSize, setPageSize] = useState(25);


  React.useEffect(() => {

  fetchAllTickets();


  }, []);


  const fetchAllTickets = () => {
  let params = {"page": page, "pageSize": pageSize, "pageLink": pageLink};
    console.log(params);

    fetch(APIURLS.getTicketsURL + "/" + new URLSearchParams(params).toString())
    .then(response => response.json())
                  .then(result => {
                      setTickets(result.tickets);
                      setMeta(result.meta)
                      }).catch((error) => {
                      console.error("Fetch API Call failed with an error" + error);
                      });

  };





  const useMetaAndSetPageLink = (pageLink) => {
          setPageLink(pageLink);
          if (meta.hasOwnProperty(pageLink)) {
              setPage(meta[pageLink]);
          }
          setTickets(null);

  };


  React.useEffect(() => {

  fetchAllTickets();

  }, [page]);




  if (tickets) {
    return (
    <div className={"container-fluid"}>
    <div className={"card-layout"}>
       <h3 className={"color-aqua"}>
        <FontAwesomeIcon icon={faClipboardList} color="#1f939c" className={"mr-2"} />
        <span className={"ml-2"}>Let's view all tickets! </span>
       </h3>
    </div>

    <div className={"row mb-2"}>
        <div className={"col-8"}>
        </div>
        <div className={"col-4"}>

        <div className={"row cursor-pointer"}>
        <div className={"col-4"}>
          <a onClick={() => useMetaAndSetPageLink("before")} className={"p-1"}><FontAwesomeIcon icon={faChevronCircleLeft} color="#1f939c" size="lg" /></a>
          <a onClick={() => useMetaAndSetPageLink("after")}className={"p-1"} ><FontAwesomeIcon icon={faChevronCircleRight} color="#1f939c" size="lg" /></a>
          <span className={"p-1"}>Show </span>

        </div>
        <div className={"col-4 p-0"}>
            <Input onChange={(event) => {setPageSize(event?.target?.value)}}
                                id="pageSizeInput"
                                name="pageSizeInput"
                                className={"cursor-pointer"}
                                type="select"
                              >
                                <option value={25}>
                                  25
                                </option>
                                <option value={30}>
                                  30
                                </option>
                                <option value={35}>
                                  35
                                </option>
                                <option value={40}>
                                  40
                                </option>
                                <option value={50}>
                                  50
                                </option>
                              </Input>
        </div>
        <div className={"col-4"}>
        <span className={"float-left"}>Results</span>
        </div>
        </div>


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
