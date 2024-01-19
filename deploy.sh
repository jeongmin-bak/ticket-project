cd /home/ubuntu

DOCKER_APP_NAME=yeti-project

EXIST_APP=$(sudo docker-compose -p ${DOCKER_APP_NAME} -f docker-compose.yml ps | grep Up)

# 배포 시작한 날짜와 시간을 기록
echo "배포 시작 일자 : $(date +%Y)-$(date +%m)-$(date +%d) $(date +%H):$(date +%M):$(date +%S)" >> /home/ubuntu/deploy.log

if [ -z "$EXIST_APP" ]; then
  # 기존에 app은 중단한다.
  echo "app 중단 시작 : $(date +%Y)-$(date +%m)-$(date +%d) $(date +%H):$(date +%M):$(date +%S)" >> /home/ubuntu/deploy.log
  sudo docker-compose -p ${DOCKER_APP_NAME} -f docker-compose.yml down
  sudo docker image prune -af

  # 새로운 app배포를 시작
  echo "app 배포 시작 : $(date +%Y)-$(date +%m)-$(date +%d) $(date +%H):$(date +%M):$(date +%S)" >> /home/ubuntu/deploy.log
  sudo docker-compose -p ${DOCKER_APP_NAME} -f docker-compose.yml up -d --build

  # app이 문제없이 배포되었는지 현재 실행 여부를 확인
  APP_HEALTH=$(sudo docker-compose -p ${DOCKER_APP_NAME} -f docker-compose.yml ps | grep Up)

  # app이 현재 실행 중이지 않다면 -> 런타임 에러 또는 다른 이유로 배포가 되지 못한 상태
  if [ -z "$APP_HEALTH" ]; then
      # slack으로 알람을 보낼 수 있는 스크립트를 실행
      sudo /home/ubuntu/slack_blue.sh
  fi
fi